# GlowinWebservice
A backend API for an e-commerce application built using Java Spring Boot and PostgreSQL, handling authentication, product management, cart operations, and order processing.

🛍️ Beauty Products E-Commerce Backend
📌 Overview

This project is a backend REST API for a beauty products e-commerce platform, built using Java Spring Boot and PostgreSQL.
It is designed to handle core e-commerce functionalities such as user authentication, product management, cart operations, and order processing, providing a scalable and secure foundation for an online beauty store.

The backend is API-driven and can be easily integrated with any frontend (Web, Mobile, or Admin Dashboard).

🎯 Project Purpose

The purpose of this project is to:

Simulate a real-world e-commerce backend

Practice Spring Boot REST API development

Implement database-driven business logic

Follow industry-standard backend architecture

Serve as a portfolio-ready backend project

🧴 Domain: Beauty Products

The platform is designed specifically for selling beauty and personal care products, such as:

Skincare products

Makeup items

Hair care products

Beauty accessories

Each product includes structured data such as pricing, category, description, and availability.

🚀 Features
🔐 Authentication & Authorization

User registration and login

Secure password handling

Role-based access (User / Admin)

Protected API endpoints

🛒 Product Management

Add, update, delete beauty products (Admin)

Fetch product listings

View product details

Category-based product filtering

🛍️ Cart Operations

Add products to cart

Update product quantity

Remove items from cart

View cart summary

📦 Order Management

Place orders from cart

View user order history

Order status tracking

Persisted order records

🛠️ Tech Stack
Backend

Java

Spring Boot

Spring Web (REST APIs)

Spring Data JPA

Spring Security

Database

PostgreSQL

Tools & Utilities

Maven

Hibernate (JPA)

RESTful architecture

JSON-based API communication

🧱 Application Architecture

The application follows a layered architecture:

Controller Layer – Handles HTTP requests and responses

Service Layer – Contains business logic

Repository Layer – Handles database interactions

Entity Layer – Defines database models

DTOs – Used for clean data transfer

This structure improves maintainability, scalability, and readability.
