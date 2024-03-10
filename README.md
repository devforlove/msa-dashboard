# msa-dashboard

간단한 게시판 서비스를 MSA로 구축해보는 멀티모듈 프로젝트입니다. 
회원(member), 게시판 등록(post-command), 리뷰 등록(review-command), 게시판/리뷰 조회(review-query), 메세지(message) 이렇게 총 5개의 서비스로 구성되어 있으며, 각각의 독립적인 프로젝트로 구성되어 있습니다.

모든 서비스는 기본적으로 Hexagonal Architecture로 구현하고, 일부 서비스에서는
Event Sourcing, CQRS 패턴이 적용되어 있습니다. 

## 패키지 구조 
## 📦 패키지

패키지 구조는 DDD(Domain-Driven-Design)의 바운디드 컨텍스트를 기반으로 합니다. CQRS 패턴을 사용하여 command(명령)용 패키지와 query(조회)용 패키지를 분리하였습니다. 

```
com.wook.top
    +- post
        +- config
        |  +- SecurityConfig
        |  +- PersistenceConfig
        |  +- SwaggerConfig
        +- command
            +- adapter
                +- out
                    +- kafka
                    |  +- PostInsertEventPublishAdapter
                    +- persistence
                    |  +- PostCreateAdapter
                    |  +- PostInsertEventHandler
                    ...
                    +- service
                    |  +- MemberClientAdapter
                +- in
                    +- web
                    |  +- PostCreateRequest
                    |  +- PostCreateController
                    |  +- PostCreateResponse
            +- application
                +- service
                |  +- PostCreatService
                +- port
                    +- out
                    |  +- PostCreatePort
                    |  +- MemberClientPort
                    |  +- PostInsertEventPublishPort
                    +- in
                    |  +- PostCreateUseCase
                    |  +- PostCreateCommand
            +- domain
            |  +- Post
            |  +- InternalPostEvent
            |  +- LikeCount
            |  +- PostLikeCountConverter
            |  +- PostEventType
        +- query
            +- dto
            |  +- PostData
            +- dao
            |  +- PostDataDao
            +- adapter
            |  +- PostCreateInfoController
```

