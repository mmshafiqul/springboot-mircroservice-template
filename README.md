# Spring Cloud Microservice Template

A production-grade Spring Cloud microservices architecture template with Config Server + Eureka + Gateway + Sample Service.

## 🏗️ Architecture Overview

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   API Gateway   │    │  Discovery      │    │   Config Server │
│   (Port 8080)   │◄──►│   Server        │◄──►│   (Port 8888)   │
│                 │    │  (Port 8761)    │    │                 │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         └───────────────────────┼───────────────────────┘
                                 │
         ┌─────────────────────────┼─────────────────────────┐
         │                         │                         │
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│  User Service   │    │  Order Service  │    │ Payment Service │
│  (Port 8082)    │    │  (Port 8083)    │    │  (Port 8084)    │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

## 📁 Project Structure

```
spring-cloud-microservice-template/
│
├── config-repo/                         # Centralized configuration (Git-backed)
│   ├── application.yml                  # Global configuration
│   ├── api-gateway.yml                  # Gateway specific config
│   ├── user-service.yml                 # User service config
│   ├── user-service-dev.yml             # Dev environment config
│   └── user-service-prod.yml            # Prod environment config
│
├── config-server/                       # Spring Cloud Config Server
│   ├── pom.xml
│   └── src/main/...
│
├── discovery-server/                    # Eureka Service Discovery
│   ├── pom.xml
│   └── src/main/...
│
├── api-gateway/                         # Spring Cloud Gateway
│   ├── pom.xml
│   └── src/main/...
│
├── user-service/                        # Sample Business Microservice
│   ├── pom.xml
│   └── src/main/...
│
├── docker-compose.yml                   # Docker orchestration
└── README.md                            # This file
```

## 🚀 Quick Start

### Prerequisites

- Java 17+
- Maven 3.6+
- Docker & Docker Compose (optional)

### Running Services

#### Option 1: Manual Startup

1. **Start Config Server** (Port 8888)
   ```bash
   cd config-server
   mvn spring-boot:run
   ```

2. **Start Discovery Server** (Port 8761)
   ```bash
   cd discovery-server
   mvn spring-boot:run
   ```

3. **Start API Gateway** (Port 8080)
   ```bash
   cd api-gateway
   mvn spring-boot:run
   ```

4. **Start User Service** (Port 8082)
   ```bash
   cd user-service
   mvn spring-boot:run
   ```

#### Option 2: Docker Compose

```bash
docker-compose up --build
```

## 🌐 Service Endpoints

### API Gateway (Port 8080)
- **Health Check**: `GET http://localhost:8080/actuator/health`
- **Routes**: `GET http://localhost:8080/actuator/gateway/routes`
- **User Service**: `GET http://localhost:8080/api/users`

### Discovery Server (Port 8761)
- **Dashboard**: `http://localhost:8761`
- **Health Check**: `GET http://localhost:8761/actuator/health`

### Config Server (Port 8888)
- **Health Check**: `GET http://localhost:8888/actuator/health`
- **User Service Config**: `GET http://localhost:8888/user-service/default`

### User Service (Port 8082)
- **Health Check**: `GET http://localhost:8082/actuator/health`
- **H2 Console**: `http://localhost:8082/h2-console`
- **API Endpoints**:
  - `POST /users` - Create user
  - `GET /users` - Get all users
  - `GET /users/{id}` - Get user by ID
  - `PUT /users/{id}` - Update user
  - `DELETE /users/{id}` - Delete user

## 🛠️ Technology Stack

- **Spring Boot 3.2.0** - Application framework
- **Spring Cloud 2023.0.0** - Microservices framework
- **Spring Cloud Config** - Centralized configuration
- **Eureka Server** - Service discovery
- **Spring Cloud Gateway** - API Gateway
- **Spring Data JPA** - Data persistence
- **H2 Database** - In-memory database
- **Maven** - Build tool
- **Docker** - Containerization

## 🔧 Configuration

### Environment Profiles

- **Development**: `application-dev.yml`
- **Production**: `application-prod.yml`

### Service Ports

| Service | Port | Description |
|---------|------|-------------|
| Config Server | 8888 | Configuration management |
| Discovery Server | 8761 | Service registry |
| API Gateway | 8080 | Single entry point |
| User Service | 8082 | Business logic |

## 📊 Monitoring & Health Checks

All services expose Spring Boot Actuator endpoints:

- `/actuator/health` - Service health status
- `/actuator/info` - Application information
- `/actuator/env` - Environment properties

## 🔄 Adding New Services

1. Create new service directory following `user-service` structure
2. Add service configuration to `config-repo/`
3. Add routing rules to `api-gateway/`
4. Update `docker-compose.yml` if needed
5. Register with Eureka discovery

## 🧪 Testing

```bash
# Test user service through gateway
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"firstName":"John","lastName":"Doe","email":"john@example.com","phoneNumber":"1234567890"}'

# Get all users
curl http://localhost:8080/api/users
```

## 🚨 Production Considerations

- Replace H2 with production database (PostgreSQL, MySQL)
- Configure proper logging and monitoring
- Implement security (OAuth2, JWT)
- Set up CI/CD pipeline
- Configure external config repository (Git)
- Add circuit breakers and retries
- Implement distributed tracing

## 📚 Documentation

- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)
- [Eureka Documentation](https://cloud.spring.io/spring-cloud-netflix/)
- [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)

## 🤝 Contributing

1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push to branch
5. Create Pull Request

## 📄 License & Attribution

**© 2026 CodeForgeX** - All Rights Reserved

This project is licensed under the proprietary **CodeForgeX License**. 

### License Terms
- **Author:** M. M. Shafiqul Islam Suzon
- **Organization:** CodeForgeX
- **License Type:** Proprietary
- **Year:** 2026

---

**👨‍💻 Lead Developer & Architect**  
**M. M. Shafiqul Islam Suzon**  
* Software Engineer | Microservices Specialist*  
**🏢 CodeForgeX** - Building Enterprise-Grade Solutions

---

*This project represents a production-grade Spring Cloud microservices architecture designed and developed by CodeForgeX. Unauthorized distribution, modification, or commercial use is strictly prohibited without explicit permission from the author and organization.*
