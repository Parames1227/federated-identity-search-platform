

# Federated Identity & Search Platform (High-Performance Discovery Service)
/* Currently it is only fir restaurants, Later I'll add more */

This project is a microservices-based backend platform designed for large-scale, high-speed entity discovery and secure identity management. It serves as a comprehensive demonstration of performance optimization, advanced data indexing, and enterprise security protocols using a modern Java/Spring Boot stack.

## Unique Selling Points & Performance Metrics ##

| Feature | Technology | Performance Gain |

| **High-Speed Caching** | **Redis** | Reduced API latency by **96%** (from ~240ms to ~9ms) on repeat search requests. |
| **Advanced Indexing** | **Elasticsearch** | Enables complex, sub-millisecond **Geospatial Queries** (location-based search) and fuzzy text matching. |
| **Stateless Identity** | **Keycloak / OAuth 2.0** | Centralized authentication; eliminates server session state in the backend for enhanced scalability. |

## Core Architecture & Engineering Solutions

### Security & Identity (Keycloak Integration)

1. **Delegated Authentication:** Implements OAuth 2.0 and OpenID Connect (OIDC) by delegating all user management and authentication flows to the **Keycloak** Identity Provider (IdP).
2. **Authorization:** Secured all endpoints via **Spring Security** using JWT validation and granular Role-Based Access Control (RBAC).
3. **User Provisioning:** Automatically provisions users into the application database upon first login, reading claims directly from the JWT.

### Data & Performance Optimization

1. **Hybrid Storage:** Uses **Elasticsearch** as the primary persistence layer, leveraging its native support for nested objects (Reviews, Photos) and geospatial data.
2. **Data Integrity (Serialization):** Resolved complex distributed serialization challenges by implementing custom Java native serialization strategies (`transient` keyword) for non-serializable objects (e.g., `GeoPoint`), ensuring cache stability.
3. **Manual Pagination:** Implemented manual sorting and pagination logic in the service layer to handle nested list objects (Reviews) efficiently.

## Development Environment

This project is orchestrated using Docker Compose to ensure rapid, consistent deployment of all supporting services.

| Service | Purpose | Port |

1. **Application** - Spring Boot Backend and React Frontend (***Currently running it on the system, later I'll containerize the whole Application***)
2. **Elasticsearch** - Primary Persistence, Search Indexing (Geo/Fuzzy) | on port: 9200 |
3. **Redis** - High-Speed Cache (Search Results) | on port: 6379 |
4. **Keycloak** - Identity Provider (Auth, Roles) | on port: 9090 |

### Getting Started

1.  **Clone the repository.**
2.  **Start Services:** Run `docker-compose up -d`.
3.  **Run Backend:** Use `mvn clean spring-boot:run` (or your IDE's run configuration with the **-Duser.timezone=UTC** flag).
4.  **Test Performance:** Use `curl` to verify the sub-10ms cache hit time.
