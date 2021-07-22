function commonGetUserInfo() {
    let param = {
        token: localStorage.getItem('token')
    }
    $.ajax({
        url: 'http://47.114.43.71:8080/user/getUserInfo',
        type: "POST",
        data: JSON.stringify(param),
        async: false,
        cache: false,
        contentType: 'application/json;charset=utf-8',
        beforeSend: function (request) {
            request.setRequestHeader('token', localStorage.getItem('token'));
        },
        success: function(result) {
            $('#top-user-name').text(result.userInfo.name);
            if (result.userInfo.name == '路西') {
                $('.header-profile-user').prop('src', 'assets/images/users/lu.png')
            } else if (result.userInfo.name == '洪哥') {
                $('.header-profile-user').prop('src', 'assets/images/users/hong.png')
            } else if (result.userInfo.name == '拓哥') {
                $('.header-profile-user').prop('src', 'assets/images/users/tuo.png')
            } else if (result.userInfo.name == '阿鸡') {
                $('.header-profile-user').prop('src', 'assets/images/users/ji.png')
            }
            localStorage.setItem('userName', result.userInfo.name);
        },
        error: function(xMLHttpRequest, textStatus, errorThrown) {
            $('#top-user-name').text('未登录');
            $('.header-profile-user').prop('src', 'assets/images/users/avatar-2.jpg');
            localStorage.removeItem('userName');
        }
    });
}

function logout() {
    localStorage.setItem('token', null);
    window.location.reload();
}

setTimeout(function (){
    commonGetUserInfo();
},0)