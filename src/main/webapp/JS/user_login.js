
    function checkall(form) {
        if (form.username.value === "") {
            alert("请输入账号！");
            form.username.focus();
            return false;
        }
        if (form.userpass.value === "") {
            alert("请输入密码！");
            form.userpass.focus();
            return false;
        }
    }
