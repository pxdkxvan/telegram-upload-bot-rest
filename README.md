# Rest Service

The **Rest Service** provides a private REST API for specific operations, including sending verification emails, processing user verification, and serving file downloads. It integrates with a PostgreSQL database for data persistence and uses SMTP for email delivery, with monitoring provided by Spring Boot Actuator.

## Table of Contents
- [Overview](#overview)
- [Supported Profiles](#supported-profiles)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [REST API Endpoints](#rest-api-endpoints)
- [Actuator Endpoints](#actuator-monitoring)
- [CI/CD Integration](#cicd-integration)
- [Security](#security)
- [Contributing](#contributing)
- [License](#license)

## Overview

The Rest Service is responsible for:
- Exposing a private REST API for internal use.
- Sending confirmation emails for user verification.
- Handling the verification process.
- Providing an endpoint for downloading files.

### Supported Profiles

The service supports the following profiles, defined in `application.yml`:
- `postgres`: Configures the PostgreSQL database connection.
- `smtp`: Sets up SMTP for sending emails.
- `actuator`: Enables Spring Boot Actuator for monitoring.

## Features

- **Private REST API**: Offers endpoints for verification and file download, restricted to authorized access.
- **Email Delivery**: Sends verification emails via SMTP.
- **PostgreSQL Integration**: Stores verification data and file metadata.
- **Actuator Monitoring**: Provides endpoints for health checks and metrics.

## Prerequisites

To run the service, ensure you have:
- Java 21 or higher
- Spring Boot 3.4.x
- Access to a PostgreSQL database
- An SMTP server for email delivery
- Gradle for dependency management

## Setup

Follow these steps to set up and run the service:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/pxdkxvan/telegram-upload-bot-rest.git
   ```

2. **Configure the following variables in a `.env` file**:
   - `REST_NAME`: Unique name for the Rest Service.
   - `REST_PORT`: Port for the Rest Service.
   - `APPLICATION_PROTOCOL`: The protocol (http or https).
   - `CONFIG_HOST`: Domain or IP for the Config Service (e.g., `config`).
   - `CONFIG_PORT`: Port for the Config Service (e.g., `8888`).
   - `POSTGRES_HOST`: Domain or IP for PostgreSQL (e.g., `postgres`).
   - `POSTGRES_PORT`: PostgreSQL port (e.g., `5432`).
   - `POSTGRES_USER`: Username for the PostgreSQL database connection (e.g., `postgres`).
   - `POSTGRES_PASSWORD`: Password for the PostgreSQL database connection (e.g., `mysecretpassword`).
   - `SMTP_PORT`: SMTP port (e.g., `587` for Gmail).
   - `ACTUATOR_ENDPOINT`: Base path for Actuator endpoints (e.g., `/actuator`).

   **Note**: SMTP credentials are encrypted via the Config Service.

3. **Build the Project**
   ```bash
   ./gradlew build
   ```

4. **Run the Service**:
   ```bash
   ./gradlew bootRun
   ```

## REST API Endpoints

The service provides the following private endpoints:
- **Send Verification Email**: Initiates the verification process by sending a confirmation email.
- **Verify User**: Completes the verification process using a provided token or code.
- **Download File**: Serves a file for authorized users.

**Note**: Endpoint details (e.g., paths, request/response formats) are restricted to internal documentation for security.

## Actuator Monitoring

The service exposes the following Actuator endpoints:
- `/actuator/health`: Checks service, database, and SMTP connection status.
- `/actuator/info`: Provides service information.
- `/actuator/metrics`: Displays performance and system metrics.
- `/actuator/loggers`: Allows viewing and managing logging levels.

These endpoints are available when the `actuator` profile is enabled in `application.yml`.

## CI/CD Integration

The service can be integrated into a CI/CD pipeline:
- Include the service startup in your deployment scripts.
- Ensure PostgreSQL and SMTP configurations are set in the target environment.

## Security

- Protect PostgreSQL and SMTP credentials using environment variables or a secrets manager.
- Restrict access to the REST API using authentication and authorization mechanisms (e.g., Spring Security).
- Limit Actuator endpoints to authorized users with Spring Security if needed.
- Use secure connections (e.g., HTTPS) for API and SMTP communication.

## Contributing

Contributions are welcome! Please submit a pull request or open an issue to discuss ideas or fixes.

## License

This project is licensed under the [MIT License](LICENSE).