document.write(`<header class="row">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.html">香樟树下BBS</a>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.html">首页</a></li>
                    <li><a href="setions.html">论坛</a></li>
                    <li><a href="tweets.html">动弹</a></li>
                    <li><a href="questions.html">问答</a></li>
                    <li><a href="activities.html">活动</a></li>
                </ul>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
                <ul class="nav navbar-nav navbar-right" id="user-log-area">
                
                <script>
                    let user = localStorage.getItem("user");
                    if (user === null || typeof user === "undefined") {
                        document.write("<li><a href='user-login.html'>登录</a></li>" +
                            "<li><a href='user-register.html'>注册</a></li>");
                    } else {
                        document.write("<li class='dropdown'>" +
                            "<a href='#' class='dropdown-toggle' data-toggle='dropdown'>个人中心<b class='caret'></b></a>" +
                            "<ul class='dropdown-menu'>" +
                                "<li><a href='user-account.html'>我的账户</a></li>" +
                                "<li><a href='user-profile.html'>我的信息</a></li>" +
                                "<li><a href='user-post.html'>我的帖子</a></li>" +
                                "<li><a href='user-tweet.html'>我的动弹</a></li>" +
                                "<li><a href='user-activity.html'>我的活动</a></li>" +
                                "<li><a href='user-page.html'>我的主页</a></li>" +
                                "<li class='divider'></li>" +
                                "<li><button type='button' class='btn btn-block btn-default' id='logOut'>退出登录</button></li>" +
                            "</ul>" +
                        "</li>");
                    }
                </script>
                </ul>
            </div>
        </div>
    </nav>
</header>`);

$("#logOut").bind("click", function (e) {
    $.ajax({
        type: "get",
        url: "/user/logOut",
        dataType: "json",
        success: function (response) {
            if (response.code == 1) {
                $("#user-log-area").html(
                    `<li><a href='user-login.html'>登录</a></li>
                    <li><a href='user-register.html'>注册</a></li>`);
                localStorage.clear();
                alert("退出登录成功！");
            }
        }
    });
});