# Task Management

## This project uses Java with Spring Boot to create an API that manages tasks. It offers easy-to-use endpoints for creating, reading, updating, and deleting tasks

### Setup Instructions
- Clone the repository.
- Configure the database settings in the application properties.
- Run the application.
- Access the API endpoints using a tool like Postman or cURL.

### Technologies Used
- Java
- Spring Boot
- MySQL

### API Endpoints
#### Create a Task (Request)
- Request Type: POST
- Endpoint: `/api/saveTask`
- Request Body:
  ``` json
  {
    "title": "Complete Report",
    "description": "Finish the quarterly report by next Friday."
  }
- Response (Success - HTTP Status Code 201 Created):
  ``` json
  {
    "id" : "1",
    "title": "Complete Report",
    "description": "Finish the quarterly report by next Friday."
  }

#### Get a Task by ID (Request)
- Request Type: GET
- Endpoint: `/api/getTask/{id}`
- Response (Success - HTTP Status Code 200 OK):
  ``` json
  {
    "id" : "1",
    "title": "Complete Report",
    "description": "Finish the quarterly report by next Friday."
  }
  
#### Get Paginated Tasks
- Request Type: GET
- Endpoint: `api\task`
- Response (Success - HTTP Status Code 200 OK)
``` json
{
   "content": [
    {
      "id": 1,
      "title": "Complete Report",
      "description": "Finish the quarterly report by next Friday."
    },
    {
      "id": 2,
      "title": "Prepare Presentation",
      "description": "Create slides for next week's team meeting."
    }
     ......
  ],
}

```
#### Update a Task (Request)
- Request Type: PUT
- Endpoint: `/api/updateTask/{id} `
- Request Body:
  ``` json
  {
    "title": "Complete Report by Thursday"
  }
- Response (Success - HTTP Status Code 200 OK):
  ``` json
  {
    "id": 1,
    "title": "Complete Report by Thursday",
    "description": "Finish the quarterly report by next Friday.",
  }

#### Delete a Task (Request)
- Request Type: DELETE
- Endpoint: `/api/deleteTask/{id}`
- Response (Success - HTTP Status Code 200 OK):
  ``` json
  {
     "message": "Task is successfully deleted"
  }
