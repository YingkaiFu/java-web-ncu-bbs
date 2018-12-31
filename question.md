##问答模块接口文档

###得到最热提问及对应的作者和回答

####url

/question/host

####请求方式

GET

####请求数据

无

####返回数据

```json 
[
    {
        "id": 2,
        "title": "无题",
        "createTime": "2018-12-26T15:18:00.000+0000",
        "clickNum": 101,
        "description": "没啥想问",
        "author": {
            "id": 1,
            "nickname": "张晓梅",
            "avatar": null
        },
        "answerNum": 2,
    },
    {
        "id": 1,
        "title": "学习困惑",
        "createTime": "2018-12-26T15:13:00.000+0000",
        "clickNum": 31,
        "description": "如何可以提高自己的学习效率？",
        "author": {
            "id": 2,
            "nickname": "罗伟",
            "avatar": null
        },
        "answerNum": 2,
    }
]
```

###得到最新提问及对应的作者和回答

####url

/question/latest

####请求方式

GET

####请求数据

无

####返回数据

```json 
[
    {
        "id": 2,
        "title": "无题",
        "createTime": "2018-12-26T15:18:00.000+0000",
        "clickNum": 101,
        "authorId": null,
        "description": "没啥想问",
        "author": {
            "id": 1,
            "nickname": "张晓梅",
            "avatar": null
        },
        "answerNum": 2,
    },
    {
        "id": 1,
        "title": "学习困惑",
        "createTime": "2018-12-26T15:13:00.000+0000",
        "clickNum": 31,
        "description": "如何可以提高自己的学习效率？",
        "author": {
            "id": 2,
            "nickname": "罗伟",
            "avatar": null
        },
        "answerNum": 2,
    }
]
```

###添加提问

####url

/question

####请求方式

POST

####请求数据

```json
{
	"id":
	"title":
	"description":
	"createTime":
	"authorId":
```

####返回数据

200 --提问成功
500 --提问失败

###删除某一提问

####url

/question/{id}

####请求方式

DELETE

####请求数据

无

####返回数据

200 --删除成功
500 --删除失败

###更新提问

####url

/question

####请求方式

PUT

####请求数据


```json
{
	"id":
	"title":
	"description":
	"createTime":
	"authorId":
```

####返回数据

200 --更新成功
500 --更新失败

###查看某一用户的所有提问

####url

/user/question/{id}

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
    "questions": [
        {
            "id": 1,
            "title": "学习困惑",
            "createTime": "2018-12-26T15:13:00.000+0000",
            "description": "如何可以提高自己的学习效率？",
        }
    ],
}
```

###获取某问题的答案及作者

####url

/question/1

####请求方式

GET

####请求数据

无

####返回数据

```json
{
    "id": 1,
    "title": "学习困惑",
    "createTime": "2018-12-26T15:13:00.000+0000",
    "clickNum": 33,
    "description": "如何可以提高自己的学习效率？",
    "author": {
        "id": 2,
        "nickname": "罗伟",
        "avatar": null
    },
    "answers": [
        {
            "id": 1,
            "questionId": null,
            "authorId": 2,
            "createTime": "2018-12-27T14:12:00.000+0000",
            "content": "这是一个测试",
            "question": null,
            "answerUser": {
                "id": 2,
                "nickname": "罗伟",
                "avatar": null
            }
        },
        {
            "id": 2,
            "questionId": null,
            "authorId": 2,
            "createTime": "2018-12-26T15:19:00.000+0000",
            "content": "困就赶快去睡觉",
            "answerUser": {
                "id": 2,
                "nickname": "罗伟",
                "avatar": null
            }
        }
    ]
}
```

###增加回答

####url

/answer

####请求方式

POST

####请求数据

```json
{
	"id":
	"content":
	"questionId":
	"authorId":
	"createTime":
}
```

####返回数据

200 --回答成功
500 --回答错误

###删除某一回答

####url

/answer/{id}

####请求方式

DELETE

####请求数据

无

####返回数据

200 --删除成功
500 --删除失败

###更新某一回答

####url

/answer

####请求方式

无

####请求数据

```json
{
	"id":
	"content":
	"questionId":
	"authorId":
	"createTime":
}
```

####返回数据

200 --更新成功
500 --更新失败

###用户查看自己的所有回答及对应的问题和提问者

####url

/user/answer/2

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
    "answers": [
        {
            "id": 1,
            "questionId": 1,
            "authorId": 2,
            "createTime": "2018-12-27T14:12:00.000+0000",
            "content": "这是一个测试",
            "question": {
                "id": 1,
                "title": "学习困惑",
                "createTime": "2018-12-26T15:13:00.000+0000",
                "description": "如何可以提高自己的学习效率？",
                "author": {
                    "id": 2,
                    "nickname": "罗伟",
                    "avatar": null
                },
            },
        },
        {
            "id": 2,
            "questionId": 1,
            "authorId": 2,
            "createTime": "2018-12-26T15:19:00.000+0000",
            "content": "困就赶快去睡觉",
            "question": {
                "id": 1,
                "title": "学习困惑",
                "createTime": "2018-12-26T15:13:00.000+0000",
                "description": "如何可以提高自己的学习效率？",
                "author": {
                    "id": 2,
                    "nickname": "罗伟",
                    "avatar": null
                },
            },
        }
    ],
}
```

###查询某一具体的回答内容及作者和问题

####url

/answer/2

####请求方式

GET

####请求数据

无

####返回数据

```json
{
    "id": 2,
    "questionId": 1,
    "createTime": "2018-12-26T15:19:00.000+0000",
    "content": "困就赶快去睡觉",
    "question": {
        "id": 1,
        "title": "学习困惑",
        "createTime": "2018-12-26T15:13:00.000+0000",
        "description": "如何可以提高自己的学习效率？",
        "author": {
            "id": 2,
            "nickname": "罗伟",
            "avatar": null
        },
    },
    "answerUser": {
        "id": 2,
        "nickname": "罗伟",
        "avatar": null
    }
}
```
