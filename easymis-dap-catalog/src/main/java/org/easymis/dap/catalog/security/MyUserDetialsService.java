package org.easymis.dap.catalog.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.easymis.dap.catalog.entity.LoginLog;
import org.easymis.dap.catalog.entity.Permission;
import org.easymis.dap.catalog.entity.Role;
import org.easymis.dap.catalog.mapper.UserMapper;
import org.easymis.dap.catalog.service.LoginLogService;
import org.easymis.dap.catalog.util.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class MyUserDetialsService implements UserDetailsService {

    @Autowired
    UserMapper userDao;
    @Autowired
    LoginLogService loginLogService;
    
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //此处的user是entity包中的user
    	org.easymis.dap.catalog.entity.User user = userDao.findByUsername(userName);
        if (user != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            //获取用户的角色集合
            List<Role> roles = user.getRoles();
            setUserPermissions(roles);
            //遍历角色集合，并获取每个角色拥有的权限
            for (Role role : roles) {
                List<Permission> permissions = role.getPermissions();

                for (Permission permission :permissions) {
                    //为每个授权中心对象写入权限名
                    grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
                }
            }
            /**此处的user是springsecurity中的一个实现了UserDetails接口的user类，因为我们没有将entity中的user去实现
             * UserDetails接口，所以只能在此处调用实现好的构造方法
             */
            saveLoginLog(user);
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }
        return null;
    }
    //获取用户权限
	private void setUserPermissions(List<Role> roles) {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session=attrs.getRequest().getSession();
		List<Permission> rolesList = new ArrayList<Permission>();
        for (Role role : roles) {
            List<Permission> permissions = role.getPermissions();
            for (Permission permission :permissions) {
            	rolesList.add(permission);
            }
        }
        List<Permission> resultList = new ArrayList<>(new HashSet<>(rolesList));
		session.setAttribute("permissions", resultList);
	}
	//写登录日志
	private void saveLoginLog(org.easymis.dap.catalog.entity.User user) {
		LoginLog bean= new LoginLog();
		bean.setCreator(user.getUsername());
		bean.setLoginType("数据资产平台");
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		bean.setIp(IPUtils.getIpAddr(attrs.getRequest()));
		bean.setDeviceType("web");
		bean.setImei("无");
		bean.setCertifiedResult("成功");
		bean.setDelegateUser("无");
		loginLogService.save(bean);
	}

}

