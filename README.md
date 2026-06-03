# ⚙️ AirSense Backend

Spring Boot backend powering the AI-Powered AirSense platform.

## 📌 Overview

The backend serves as the core processing engine for the AirSense ecosystem. It retrieves air quality and weather information from external APIs, processes environmental data, generates health advisories, and exposes REST endpoints for the frontend dashboard.

---

## 🚀 Features

### 🌎 AQI API

* Real-time AQI retrieval
* PM2.5 monitoring
* PM10 monitoring
* AQI categorization

### 🌤 Weather API

* Temperature
* Humidity
* Wind Speed
* Weather Conditions

### 🧠 Smart Health Advisory

* AQI-based recommendations
* Pollution alerts
* Health risk assessment

### 🔌 REST API Services

* JSON responses
* Cross-Origin support
* Frontend integration

### ☁️ Deployment Ready

* Render deployment support
* Docker support
* Cloud-ready architecture

---

## 🛠 Technology Stack

* Java 17
* Spring Boot
* Gradle
* REST APIs
* OpenWeather API
* Docker

---

## API Endpoints

### Test API

GET /api/test

### AQI API

GET /api/aqi?lat={latitude}&lon={longitude}

### Weather API

GET /api/weather?lat={latitude}&lon={longitude}

### Health Advisory

GET /api/advice

---

## Run Locally

### Build

./gradlew build

### Start

./gradlew bootRun

Backend URL:

http://localhost:8080

---

## Deployment

Hosted on Render Cloud Platform.

---

## Developer

Samya Sarkar

Electronics & Communication Engineering Student

---

## License

Educational and Research Purpose Only.
