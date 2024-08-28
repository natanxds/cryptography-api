# Cryptography Application

This is a Spring Boot application that provides a RESTful API for managing encrypted transactions. The application uses Jasypt for encryption and decryption of sensitive data.

## Technologies Used

- Java 17
- Spring Boot
- Maven
- Jasypt
- H2 Database
- Lombok

## Getting Started

### Prerequisites

- Java 17
- Maven

### Running the Application

1. Clone the repository
2. Navigate into the directory: `cd cryptography`
3. Run the application: `mvn spring-boot:run`

## API Endpoints

### Create a Transaction

- **URL:** `/api/v1/transactions`
- **Method:** `POST`
- **Body:** `{ "userDocument": "<user_document>", "creditCardToken": "<credit_card_token>", "value": <value> }`

### Update a Transaction

- **URL:** `/api/v1/transactions/{id}`
- **Method:** `PUT`
- **Body:** `{ "value": <new_value> }`

### List All Transactions

- **URL:** `/api/v1/transactions`
- **Method:** `GET`
- **Parameters:** `page=<page_number>&pageSize=<page_size>`

### Get a Transaction by ID

- **URL:** `/api/v1/transactions/{id}`
- **Method:** `GET`

### Delete a Transaction

- **URL:** `/api/v1/transactions/{id}`
- **Method:** `DELETE`

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)
