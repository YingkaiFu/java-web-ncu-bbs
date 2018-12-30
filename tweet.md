##动弹模块接口文档

###查询某一具体动弹

####url

/tweet/{id}

####请求方式

GET

####请求数据

无

####返回数据

```json
{
    "id": 1,
    "content": "作业太多，很烦，每天熬夜，我的黑眼圈没救了",
    "createTime": "2018-12-26T00:00:00.000+0000",
    "author": {
        "id": 1,
        "nickname": "张晓梅",
    }
}
```

###显示某一用户的全部动弹

####url

user/tweet/{id}

####请求方式

GET

####请求数据

无

####返回数据

```json
[
    {
        "id": 1,
        "nickname": "张晓梅",
        "tweets": [
            {
                "id": 1,
                "content": "今日无话可说",
                "createTime": "2018-12-26T20:11:00.000+0000",
                "authorId": 1,
            }
        ]
    }
]
```

###显示全部动弹

####url

/tweet

####请求方式

GET

####请求数据

无

####返回数据

```json 
[
    {
        "id": 2,
        "content": "今日无话可说",
        "createTime": "2018-12-26T20:11:00.000+0000",
        "authorId": null,
        "author": {
            "id": 2,
            "nickname": "张晓梅",
        }
    },
    {
        "id": 1,
        "content": "作业太多，很烦，每天熬夜，我的黑眼圈没救了",
        "createTime": "2018-12-26T00:00:00.000+0000",
        "authorId": null,
        "author": {
            "id": 1,
            "nickname": "张晓梅",
        }
    },
    {
        "id": 3,
        "content": "随便插一句",
        "createTime": "2018-12-25T20:47:04.000+0000",
        "authorId": null,
        "author": {
            "id": 3,
            "nickname": "罗伟",
        }
    },
    {
        "id": 4,
        "content": "改一下看看",
        "createTime": "2018-12-12T20:47:13.000+0000",
        "authorId": null,
        "author": {
            "id": 4,
            "nickname": "罗伟",
        }
    }
]
```

###删除某一动弹

####url

/tweet/delete/{id}

####请求方式

GET

####请求数据

无

####返回数据

200 -- 删除成功

500 -- 删除失败

###发布动弹动弹

####url

/tweet

####请求方式

POST

####请求数据

```json
{
    "id":
	"content":
	"createTime":
	"authorId":
}
```

####返回数据

200 -- 发布成功
500 -- 发布失败

###更新某一动弹

####url

/tweet

####请求方式

PUT

####请求数据


```json
{
    "id":
	"content":
	"createTime":
	"authorId":
}
```

####返回数据

200 -- 更新成功
500 -- 更新失败