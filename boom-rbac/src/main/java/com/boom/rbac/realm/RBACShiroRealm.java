package com.boom.rbac.realm;

import com.boom.rbac.domain.Permission;
import com.boom.rbac.domain.Role;
import com.boom.rbac.domain.User;
import com.boom.rbac.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by summer on 2017/12/7.
 */
public class RBACShiroRealm extends AuthorizingRealm{

    private static final Logger log = LoggerFactory.getLogger(RBACShiroRealm.class);

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("权限配置===>RBACShiroRealm.doGetAuthorizationInfo()");
        User user = (User) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        for (Role role : user.getRoles()) {
            authorizationInfo.addRole(role.getName());
            for (Permission permission : role.getPermissions()) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*log.info("RBACShiroRealm.doGetAuthenticationInfo(),用户身份认证");
        String userName = (String) authenticationToken.getPrincipal();

        //从数据库中，根据当前用户名查找对应的用户
        User user = userService.queryByName(userName);

        if (null == user) {
            log.info("当前用户不存在");
        }


        ByteSource pwsdSalt = ByteSource.Util.bytes(user.getCredentialSalt());
        return new SimpleAuthenticationInfo(userName,
                    user.getPassword(),
                    pwsdSalt,
                    getName());*/
        return null;
    }

    @Override
    public String getName() {
        return "RBACShiroRealm";
    }
}
