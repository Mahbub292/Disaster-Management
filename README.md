# Disaster Management Web Application

This is a **Disaster Management Web Application** built using **Spring Boot** for the backend and **React.js** for the frontend. The application allows administrators to manage donations and volunteers effectively.

## Project Structure

### Frontend: `disaster-frontend`
- Developed with **React.js**
- Uses **Tailwind CSS** for styling
- Main components:
  - `AdminHome.js`: Admin dashboard
  - `Donation.js`: Handles donations
  - `Home.js`: Home page
  - `Login.js`: User authentication
  - `Registration.js`: User registration
  - `VolunteerList.js`: Displays volunteers
  - `Volunteers.js`: Volunteer management
- Main entry point: `App.js`

### Backend: `disaster-management-backend`
- Developed with **Spring Boot** and **Spring Security**
- Uses **PostgreSQL** as the database
- Implements **JWT Authentication**
- Key packages:
  - `config/`: Security configurations (JWT, CORS)
  - `controller/`: API endpoints for users and admin
  - `model/`: Entity classes for `Users` and `Donations`
  - `repo/`: Repository interfaces for database interactions
  - `service/`: Business logic including authentication and user services

## Features
- User Registration & Login
- JWT Authentication
- Admin Dashboard for Managing Volunteers and Donations
- Secure API with Spring Security
- React.js Frontend with Tailwind CSS

## Setup Instructions

### Prerequisites
- Node.js & npm
- Java 17+
- PostgreSQL Database
- Maven

### Backend Setup
1. Navigate to `disaster-management-backend`
2. Configure PostgreSQL database in `application.properties`
3. Run the backend using:
   ```sh
   mvn spring-boot:run
   ```

### Frontend Setup
1. Navigate to `disaster-frontend`
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the frontend:
   ```sh
   npm start
   ```

### API Endpoints
- `POST /login`: User Login
- `POST /register`: User Registration
- `GET /volunteers`: Fetch Volunteers
- `POST /donation`: Make a Donation

## Technologies Used
- **Frontend:** React.js, Tailwind CSS
- **Backend:** Spring Boot, Spring Security, JWT, PostgreSQL
- **API Communication:** RESTful API

## Contributing
Feel free to fork this repository and make pull requests with improvements or feature additions.

## License
This project is open-source under the MIT License.

