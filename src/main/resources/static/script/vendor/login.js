var login={isSyncQRLoginStatus:false,init:function(){var a=this;$("#refresh-qrcode-link").click(function(b){b.preventDefault();a.showQRImage()});$(".login-header h2").click(function(c){c.preventDefault();var d=$("#login-panel");d.removeClass("login-quick");d.removeClass("login-static");var b=$(this).attr("class");if(b=="static"){d.addClass("login-static")}else{d.addClass("login-quick");a.showQRImage()}});$("#reload-captchaCode-link").click(function(b){b.preventDefault();a.reloadCaptchaCode()});$("input.form-control").blur(function(){if($(this).val()==""){$(this).addClass("empty")}else{$(this).removeClass("empty")}});$("#login-form").submit(function(d){var e=$.trim($("#mobile").val());var c=$.trim($("#password").val());var b=$.trim($("#captchaCode").val());if(e==""){alertify.alert("请输入登录手机号");$("#mobile").focus();return false}if(c==""){alertify.alert("请输入登录密码");$("#password").focus();return false}if(b==""){alertify.alert("请输入验证码");$("#captchaCode").focus();return false}a.doLogin(e,c,b);return false})},doLogin:function(d,b,a){var f=this;var c=$("#login-button").button("loading");var e={};e.username=d;e.password=b;e.captchaCode=a;$.ajax({url:"/login",type:"POST",data:e,dataType:"json",timeout:60000,error:function(){c.button("reset");f.reloadCaptchaCode();alertify.alert("登录失败，请确认输入的手机号和密码是否正确")},success:function(g){c.button("reset");if(g.code==1){toastr.success("登录成功");setTimeout(function(){window.location=_nextUrl},500);return}f.reloadCaptchaCode();alertify.alert(g.message);return}})},reloadCaptchaCode:function(){$("#captchaCodeImage").attr("src","/captchaCode?rand="+Math.floor(Math.random()*100))},showQRImage:function(){var b=this;$("#qrcode-image").attr("src","/login/qrcode?rand="+Math.floor(Math.random()*100));if(!b.isSyncQRLoginStatus){b.isSyncQRLoginStatus=true;var a=window.setInterval(b.getQRLoginStatus,3000)}},getQRLoginStatus:function(){$.ajax({url:"/login/qrcode/status?random="+Math.random(),type:"GET",dataType:"json",timeout:60000,success:function(a){if(a.code<=0){return}if(a.items.status){toastr.success("登录成功");setTimeout(function(){window.location=_nextUrl},500)}return}})}};$(function(){login.init()});