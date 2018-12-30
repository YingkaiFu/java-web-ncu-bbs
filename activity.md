##活动模块接口

###创建活动

####url

/activity

####请求方式

POST

####请求数据
```json
{
	 "id": 4,
     "registrationStartTime": "2018-12-11T04:00:00.000+0000",
     "registrationEndTime": "2018-12-20T04:00:00.000+0000",
     "activityStartTime": "2018-12-28T04:00:00.000+0000",
     "activityEndTime": "2019-01-31T04:00:00.000+0000",
     "locale": "南昌大学正气广场",
     "authorId": 2,
     "status": true,
     "description": "如何可以提高自己的学习效率？"
}
```

####返回数据

###删除活动

####url

/activity/{id}

####请求方式

DELETE

####请求数据

无

####返回数据

200 --删除成功
500 --删除失败

###更新活动

####url

/activity/{id}

####请求方式

PUT

####请求数据

```json
{
     "registrationStartTime": "2018-12-11T04:00:00.000+0000",
     "registrationEndTime": "2018-12-20T04:00:00.000+0000",
     "activityStartTime": "2018-12-28T04:00:00.000+0000",
     "activityEndTime": "2019-01-31T04:00:00.000+0000",
     "locale": "南昌大学正气广场",
     "authorId": 2,
     "status": true,
     "description": "如何可以提高自己的学习效率？"
}
```

####返回数据

200 --更新成功
500 --更新失败

###查询某一具体活动（显示报名数量）

####url

/activity/{id}

####请求方式

GET

####请求数据

无

####返回数据

```json
{
    "id": 1,
    "registrationStartTime": "2018-12-09T04:00:00.000+0000",
    "registrationEndTime": "2018-12-12T04:00:00.000+0000",
    "activityStartTime": "2018-12-16T04:00:00.000+0000",
    "activityEndTime": "2018-01-01T04:00:00.000+0000",
    "locale": "南昌大学休闲广场",
    "authorId": 2,
    "status": true,
    "description": "如何可以提高自己的学习效率？",
    "applicantNum": 1,
    "creater": {
        "id": null,
        "nickname": "罗伟",
        "avatar": null
    }
}
```

###查询某用户所有已经创建的活动

####url

/user/create/{id}

####请求方式

GET

####请求数据

无

####返回数据

```json
{
    "id": 2,
    "nickname": "罗伟",
    "avatar": null
    "create": [
        {
            "id": 1,
            "registrationStartTime": "2018-12-09T04:00:00.000+0000",
            "registrationEndTime": "2018-12-12T04:00:00.000+0000",
            "activityStartTime": "2018-12-16T04:00:00.000+0000",
            "activityEndTime": "2018-01-01T04:00:00.000+0000",
            "locale": "南昌大学休闲广场",
            "authorId": 2,
            "status": true,
            "description": "如何可以提高自己的学习效率？",
        },
        {
            "id": 4,
            "registrationStartTime": "2018-12-11T04:00:00.000+0000",
            "registrationEndTime": "2018-12-20T04:00:00.000+0000",
            "activityStartTime": "2018-12-28T04:00:00.000+0000",
            "activityEndTime": "2019-01-31T04:00:00.000+0000",
            "locale": "南昌大学正气广场",
            "authorId": 2,
            "status": true,
            "description": "如何可以提高自己的学习效率？",
        }
    ],
}
```

###查询某用户所有已经参与的活动

####url

user/enter/{id}

####请求方式

GET

####请求数据

无

####返回数据

```json
{
    "id": 1,
    "nickname": "张晓梅",
    "avatar": null
    "enter": [
        {
            "id": 1,
            "registrationStartTime": "2018-12-09T04:00:00.000+0000",
            "registrationEndTime": "2018-12-12T04:00:00.000+0000",
            "activityStartTime": "2018-12-16T04:00:00.000+0000",
            "activityEndTime": "2018-01-01T04:00:00.000+0000",
            "locale": "南昌大学休闲广场",
            "status": true,
            "description": "如何可以提高自己的学习效率？",
            "creater": {
                "id": 2,
                "nickname": "罗伟",
                "avatar": null
            }
        },
        {
            "id": 4,
            "registrationStartTime": "2018-12-11T04:00:00.000+0000",
            "registrationEndTime": "2018-12-20T04:00:00.000+0000",
            "activityStartTime": "2018-12-28T04:00:00.000+0000",
            "activityEndTime": "2019-01-31T04:00:00.000+0000",
            "locale": "南昌大学正气广场",
            "status": true,
            "description": "如何可以提高自己的学习效率？",
            "creater": {
                "id": 2,
                "nickname": "罗伟",
                "avatar": null
            }
        }
    ]
}
```

###最新活动(开始时间)

####url

/activity/latest

####请求方式

GET

####请求数据

无

####返回数据

```json
[
    {
        "id": 4,
        "registrationStartTime": "2018-12-11T04:00:00.000+0000",
        "registrationEndTime": "2018-12-20T04:00:00.000+0000",
        "activityStartTime": "2018-12-28T04:00:00.000+0000",
        "activityEndTime": "2019-01-31T04:00:00.000+0000",
        "locale": "南昌大学正气广场",
        "authorId": 2,
        "status": true,
        "description": "如何可以提高自己的学习效率？",
        "applicantNum": 2,
        "creater": {
            "id": 2,
            "nickname": "罗伟",
            "avatar": null
        }
    },
    {
        "id": 1,
        "registrationStartTime": "2018-12-09T04:00:00.000+0000",
        "registrationEndTime": "2018-12-12T04:00:00.000+0000",
        "activityStartTime": "2018-12-16T04:00:00.000+0000",
        "activityEndTime": "2018-01-01T04:00:00.000+0000",
        "locale": "南昌大学休闲广场",
        "authorId": 2,
        "status": true,
        "description": "如何可以提高自己的学习效率？",
        "applicantNum": 1,
        "creater": {
            "id": 2,
            "nickname": "罗伟",
            "avatar": null
        }
    }
]

```

###最热活动(报名数量）

####url

/activity/host

####请求方式

GET

####请求数据

无

####返回数据

```json
[
    {
        "id": 4,
        "registrationStartTime": "2018-12-11T04:00:00.000+0000",
        "registrationEndTime": "2018-12-20T04:00:00.000+0000",
        "activityStartTime": "2018-12-28T04:00:00.000+0000",
        "activityEndTime": "2019-01-31T04:00:00.000+0000",
        "locale": "南昌大学正气广场",
        "authorId": 2,
        "status": true,
        "description": "如何可以提高自己的学习效率？",
        "applicantNum": 2,
        "creater": {
            "id": 2,
            "nickname": "罗伟",
            "avatar": null
        }
    },
    {
        "id": 1,
        "registrationStartTime": "2018-12-09T04:00:00.000+0000",
        "registrationEndTime": "2018-12-12T04:00:00.000+0000",
        "activityStartTime": "2018-12-16T04:00:00.000+0000",
        "activityEndTime": "2018-01-01T04:00:00.000+0000",
        "locale": "南昌大学休闲广场",
        "authorId": 2,
        "status": true,
        "description": "如何可以提高自己的学习效率？",
        "applicantNum": 1,
        "creater": {
            "id": 2,
            "nickname": "罗伟",
            "avatar": null
        }
    }
]
```
###报名活动

####url

/enter

####请求方式

POST

####请求数据

```json
{
	"id":
	"applicantId":
	"activityId":
}
```

####返回数据

200 --报名成功
500 --报名失败

###管理员登录

####url

/admin/login

####请求方式

POST

####请求数据

```json
{
	"name":strong
	"password":StrongAdmin
}
```

####返回数据

200 --管理员登录成功
500 --账号或者密码错误

###管理员退出登录

####url

admin/logout

####请求方式

GET

####请求数据

无

####返回数据

200 --退出登录成功
500 --退出登录失败

