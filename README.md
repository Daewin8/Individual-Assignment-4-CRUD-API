# CRUD API

The REST API performs CRUD operations on Animals objects as described below.

## Installation
- Get the project
    - clone
  
        `git clone (https://github.com/Daewin8/Individual-Assignment-4-CRUD-API.git)`
    - download zip.
- Open the project in IntelliJ.
  - You MUST have the database up and running before running the project! 
    - Open your XAMPP Control Panel.
    - Start the Apache server.
    - Start MySQL.
    - Click on MySQL "Admin" to open up the DBMS.
    - Ensure the database that you need is available.
- Build and run the main class. You should see 2 new tables created in the aforementioned database.

## API Endpoints
Use POSTMAN to try the following endpoints:

## Get list of Animals

### Request

    `GET /animal/all`

    `(http://localhost:8080/animals/all)`

   
### Response

     [
   
     {"animalId": 1, "name": "sample1", "scientific name": "sample1", "species": "Birds", "habitat": "Forests", "description": "Has a big and color wings"}, 
   
     {"animalId": 2, "name": "sample2", "scientific name": "sample2", "species": "Bear", "habitat": "Forests", "description": "Dark spots around the eyes"}, 
   
     {"animalId": 3, "name": "sample3", "scientific name": "sample3", "species": "Deer", "habitat": "Lake", "description": "huge antler and about 6ft tall"}
   
     ]

## Get a specific Animal
1
### Request

`GET /animal/{animalId}`

`http://localhost:8080/animal/1`

### Response

    {
      "animalId": 1, "name": "sample1", "scientific name": "sample2", "species": "Bear", "habitat": "Forests", "description": "Has a big and color wings"
    }

     
## Create a new Animal

### Request

    `POST /animal/new`
    
    `http://localhost:8080/animal/new` --data '{"name": "sample4", "scientific name": "sample4", "species": "Bear", "habitat": "Forests", "description": "dark brown fur"}'

   ### Response

   [
   
     {"animalId": 1, "name": "sample1", "scientific name": "sample1", "species": "Birds", "habitat": "Forests", "description": "Has a big and color wings"}, 
   
     {"animalId": 2, "name": "sample2", "scientific name": "sample2", "species": "Bear", "habitat": "Forests", "description": "Dark spots around the eyes"}, 
   
     {"animalId": 3, "name": "sample3", "scientific name": "sample3", "species": "Deer", "habitat": "Lake", "description": "huge antler and about 6ft tall"}

     {"animalId": 4, "name": "sample4", "scientific name": "sample4", "species": "Bear", "habitat": "Forests", "description": "dark brown fur"}
   
  ]

## Get Animals by Species

### Request

    `GET /animal?species=Bear`

    `http://localhost:8080/animal?species=Bear`

   
### Response

     [
   
      {"animalId": 2, "name": "sample2", "scientific name": "sample2", "species": "Bear", "habitat": "Forests", "description": "Dark spots around the eyes"}, 
   
      {"animalId": 4, "name": "sample4", "scientific name": "sample4", "species": "Bear", "habitat": "Forests", "description": "dark brown fur"}
   
     ]

## Get Animals by Habitat

### Request

    `GET /students?habitat=Forests`

    `http://localhost:8080/animal?habitat=Forests`

   
### Response

   [
   
     {"animalId": 1, "name": "sample1", "scientific name": "sample1", "species": "Birds", "habitat": "Forests", "description": "Has a big and color wings"}, 
   
     {"animalId": 2, "name": "sample2", "scientific name": "sample2", "species": "Bear", "habitat": "Forests", "description": "Dark spots around the eyes"}, 

     {"animalId": 4, "name": "sample4", "scientific name": "sample4", "species": "Bear", "habitat": "Forests", "description": "dark brown fur"}
     
   ]

## Update an existing Animal

### Request

    `PUT /animal/update/{animalId}`
    
    `http://localhost:8080/animal/update/1` --data '{ "name": "sampleUpdated", "scientific name": "sampleUpdated", "species": "Birds", "habitat": "Mountains", "description": "Giant wings and can dive really fast"}'

   ### Response
   
    {
      "animalId": 1, "name": "sampleUpdated", "scientific name": "sampleUpdated", "species": "Birds", "habitat": "Mountains", "description": "Giant wings and can dive really fast"
    }


## Delete an existing Animal

### Request

    `DELETE /animal/delete/{animalId}`
    
    `http://localhost:8080/animal/delete/1`

   ### Response
   
   [
   
     {"animalId": 2, "name": "sample2", "scientific name": "sample2", "species": "Bear", "habitat": "Forests", "description": "Dark spots around the eyes"}, 
   
     {"animalId": 3, "name": "sample3", "scientific name": "sample3", "species": "Deer", "habitat": "Lake", "description": "huge antler and about 6ft tall"}

     {"animalId": 4, "name": "sample4", "scientific name": "sample4", "species": "Bear", "habitat": "Forests", "description": "dark brown fur"}
   
  ]
