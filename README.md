# spring-cloud-msa-work
spring-cloud-msa-work - Spring Cloud(MSA) Tutorials 
# ####################################################################

* [Spring](https://spring.io/)
* [microservices](https://spring.io/microservices)
* [cloud](https://spring.io/cloud) 

# ####################################################################
# Reference
https://12factor.net/ko/
https://happycloud-lee.tistory.com/207

# ####################################################################

# Micro Service Architecture

* Monolithic Architecture

전체 애플리케이션이 하나로 되어있어서 보통 동일한 개발 툴을 사용해 개발되며, 배포 및 테스트도 하나의 애플리케이션만 수행하면 되기 때문에 개발 및 환경설정이 간단
또한 각 컴포넌트들이 함수로 호출 되기 때문에 성능에 제약이 덜하고, 운영 관리가 용이 이런 장점 때문에 작은 볼륨의 시스템을 개발할 때는 매우 유용하지만 시스템이 커지기 시작하고 여러 컴포넌트들이 더해지면 문제가 발생하기 시작

빌드 시간 및 테스트시간, 그리고 배포시간이 오래 걸림
서비스를 부분적으로 scale-out 하기가 어려움
하나의 서비스가 모든 서비스에 영향
서비스/프로젝트가 커지면 커질수록, 영향도 파악 및 전체 시스템 구조의 파악에 어려움


* MSA (Micro Service Architecture)

"the microservice architectural style is an approach to developing a single application as a suite of small services, each running in its own process and communicating with lightweight mechanisms, often an HTTP resource API. These services are built around business capabilities and independently deployable by fully automated deployment machinery."
참조 : https://martinfowler.com/articles/microservices.html

MSA는 기존의 하나의 application 형태(Monolithic Architecture)가 아닌 application을 서비스별로 나누어 독립적으로 개발하는 아키텍처
단일 프로그램을 각 컴포넌트 별로 나누어 작은 서비스의 조합으로 구축하는 방법
각 서비스들은 API 호출을 하는 형식으로 통신

MSA 장점
- 빠르고 간단한 배포
- 시스템의 선택적 확장
- Polyglot 아키텍처 지원

MSA 단점 
- 기술 복잡도가 높음
- 느린 속도 
- 관리 포인트 증가 
- 테스트 / 트랜잭션 - 서비스가 분리되어 있기 때문에 테스트와 트랜잭션의 복잡도가 증가하고, 많은 자원을 필요
- 데이터 관리 - 데이터가 여러 서비스에 걸쳐 분산되기 때문에 한번에 조회하기 어렵고, 데이터의 정합성 또한 관리하기 어려움


# ####################################################################

# Spring Cloud Projects

<li class="sidebar_project active">
<div>
<a href="https://spring.io/projects/spring-cloud">Spring Cloud</a>
</div>
<ul class="sidebar_children">
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-azure">
<span>Spring Cloud Azure</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-alibaba">
<span>Spring Cloud Alibaba</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-aws">
<span>Spring Cloud for Amazon Web Services</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-bus">
<span>Spring Cloud Bus</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-circuitbreaker">
<span>Spring Cloud Circuit Breaker</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-cli">
<span>Spring Cloud CLI</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-cloudfoundry">
<span>Spring Cloud for Cloud Foundry</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-cloudfoundry-service-broker">
<span>Spring Cloud - Cloud Foundry Service Broker</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-commons">
<span>Spring Cloud Commons</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-config">
<span>Spring Cloud Config</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-connectors">
<span>Spring Cloud Connectors</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-consul">
<span>Spring Cloud Consul</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-contract">
<span>Spring Cloud Contract</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-function">
<span>Spring Cloud Function</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-gateway">
<span>Spring Cloud Gateway</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-gcp">
<span>Spring Cloud GCP</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-kubernetes">
<span>Spring Cloud Kubernetes</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-netflix">
<span>Spring Cloud Netflix</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-open-service-broker">
<span>Spring Cloud Open Service Broker</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-openfeign">
<span>Spring Cloud OpenFeign</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-pipelines">
<span>Spring Cloud Pipelines</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-schema-registry">
<span>Spring Cloud Schema Registry</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-security">
<span>Spring Cloud Security</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://cloud.spring.io/spring-cloud-skipper">
<span>Spring Cloud Skipper</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-sleuth">
<span>Spring Cloud Sleuth</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://cloud.spring.io/spring-cloud-stream">
<span>Spring Cloud Stream</span>
</a>
</li>
<li class="sidebar_child">
 <a href="https://spring.io/projects/spring-cloud-stream-applications">
<span>Spring Cloud Stream Applications</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-task">
<span>Spring Cloud Task</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-task-app-starters">
<span>Spring Cloud Task App Starters</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-vault">
<span>Spring Cloud Vault</span>
</a>
</li>
<li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-zookeeper">
<span>Spring Cloud Zookeeper</span>
</a>
</li>
 <li class="sidebar_child">
<a href="https://spring.io/projects/spring-cloud-app-broker">
<span>Spring Cloud App Broker</span>
</a>
</li>
</ul>
</li>

분산 컨피규레이션

    Spring Cloud Config

    Spring Cloud Zookeeper Config

    Spring Cloud Consul Config

    Spring Cloud Etcd Config

    Spring Cloud Kubernetes Config


서비스 디스커버리

    Spring Cloud Eureka

    Spring Cloud Zookeeper Discovery

    Spring Cloud Consul Discovery

    Spring Cloud Etcd Discovery

    Spring Cloud Kubernetes Discovery


상호 통신

    Spring Cloud Hystrix

    Spring Cloud Ribbon

    Spring Cloud Feign

    Spring Cloud Zuul


추적

    Spring Cloud Sleuth

    Spring Cloud Sleuth Zipkin

    Spring Cloud Sleuth Stream


클라우드 플랫폼 지원

    Spring Cloud Cloud Foundry

    Spring Cloud AWS

    Spring Cloud Function

    Spring Cloud Connectors


메시징 및 통합

    Spring Cloud Stream

    Spring Cloud Bus

    Spring Cloud Stream Apps

    Spring Cloud Data Flow


기타

    Spring Cloud Contract

    Spring Cloud Security

    Spring Cloud Task

    Spring Cloud Cluster

# ####################################################################

# Spirng Cloud

## Service discovery 
https://spring.io/guides/gs/service-registration-and-discovery/
https://spring.io/guides/gs/spring-cloud-loadbalancer/
Netflix Eureka, HashiCorp Consul

## API gateway
https://spring.io/projects/spring-cloud-gateway 
https://spring.io/blog/2019/06/18/getting-started-with-spring-cloud-gateway

## Cloud configuration
https://spring.io/projects/spring-cloud-config
https://spring.io/guides/gs/centralized-configuration/

## Circuit breakers
https://spring.io/projects/spring-cloud-circuitbreaker
https://spring.io/guides/gs/cloud-circuit-breaker/
Resilience4J, Sentinel, Hystrix

## Tracing
https://spring.io/projects/spring-cloud-sleuth
https://zipkin.io/

# Testing
https://spring.io/projects/spring-cloud-contract
https://spring.io/guides/gs/contract-rest/

# ####################################################################






