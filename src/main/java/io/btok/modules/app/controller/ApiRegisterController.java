package io.btok.modules.app.controller;


import io.btok.common.utils.R;
import io.btok.common.utils.ShiroUtils;
import io.btok.common.validator.Assert;
import io.btok.modules.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Constants;

/**
 * 注册

 */
@RestController
@RequestMapping("/app")
public class ApiRegisterController {
    @Autowired
    private UserService userService;

    /**
     * pc 手机号注册
     */
    @PostMapping("register")
    public R register(String mobile, String password, String cid,String captcha,String fromId){
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");
		String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
		if(!captcha.equalsIgnoreCase(kaptcha)){
			return R.error("验证码不正确");
		}
        userService.save(mobile, password,cid,fromId,"0","0","",1,1);

        return R.ok();
    }


    /**
     * pc 邮箱注册
     */
    @PostMapping("registEmail")
    public R registEmail(String email, String password, String cid, String captcha,String fromId){
        Assert.isBlank(email, "邮箱不能为空");
        Assert.isBlank(password, "密码不能为空");
		String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
		if(!captcha.equalsIgnoreCase(kaptcha)){
			return R.error("验证码不正确");
		}
        userService.save(email, password,cid,fromId,"0","0","",1,2);

        return R.ok();
    }
    
    /**
     * 客户端注册
     * @param email 邮箱
     * @param mobile 电话
     * @param password 密码
     * @param cid 国籍代码
     * @param captcha 验证码
     * @param fromId 推荐ID
     * @param clientName 客户端设备名称
     * @param clientType 客户端类型  
     * @param longitude 经度
     * @param latitude 维度
     * @param type 1手机注册  2邮箱注册
     * @return
     */
    @PostMapping("registClient")
    public R registClient(String email,String mobile, String password, String cid, String captcha,String fromId,
    		String clientName,Integer clientType,String longitude,String latitude,Integer type){

		String username = "";
		if(type == 1){
			username = mobile;
	        Assert.isBlank(username, "手机不能为空");
		}else{
			username = email;
	        Assert.isBlank(username, "邮箱不能为空");
		}
        Assert.isBlank(password, "密码不能为空");
		String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
		if(!captcha.equalsIgnoreCase(kaptcha)){
			return R.error("验证码不正确");
		}

        userService.save(username, password,cid,fromId,longitude,latitude,clientName,clientType,type);

        return R.ok();
    }
}
