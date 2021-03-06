<h1 align="center">
    Wikipedia
</h1>

A RESTful facade backend API with CRUD services:
- Add Offert service
- Find Offert service
- Delete Offert
- Update Offert


## Toolset
- Spring Cloud
- Jackson Annotations
- In Memory Persistence in "Static Map"
- Maven
- Git
- Mockito

## Features
### Implemented requirements
- endpoint for views the offerts details with comments (in JSON)
- endpoint for creating offert
- endpoint for deleting offert
- endpoint for update offert
- backend services able to invalidate an offert after the specific delay time.



### Nuances
- An offer is time-bounded, with the length of time an offer is valid for defined as part of the offer, and should expire automatically. Offers may also be explicitly cancelled before they expire.

### Assumption
- All the users just are logged into the system.
- The information about a single user to extract the information are not included into the example
- The propagation of this information it's material fo security layer and will be automatically apply into the specific layer ( ex. persistence ) on demand.  

### Unit and Integration Testing
- mocking
- service unit testing
- controller integration testing using *MockMvc* instance to setup a Spring MVC context with a web server


## Prerequisites
- Requires at least Java Runtime 1.8 - [download](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

## Quick start
Below all the commands to clone, build and run the project with Maven and Java 8 JDK:
- `git clone https://github.com/turellaa/worldpay.git`
- `cd worldpay`
- `mvn -T 4 clean install`
- `java -jar target/worldpay-0.0.1-SNAPSHOT.jar`
- the embedded servlet container starts at `http://localhost:2222`

## Running

### GET offert 
- URL is `http://localhost:2222/worldpay/product/all`

JSON examples to POST a movie with authentication:
````
[
    {
        "offerId": 1,
        "comments": [
            "first com",
            "second com",
            "third com"
        ],
        "active": true,
        "delay_time": 0,
        "creationTime": 1539459825994,
        "expirationTime": null,
        "products": []
    },
    {
        "offerId": 2,
        "comments": [
            "first5 com",
            "second5 com",
            "third5 com"
        ],
        "active": true,
        "delay_time": 30,
        "creationTime": 1539459834830,
        "expirationTime": null,
        "products": []
    }
]
````

### GET {ID} offert
- URL is `http://localhost:2222/worldpay/product/{id}`

**http://localhost:2222/worldpay/product/1**
JSON examples to GET a offer by it's id :
````
{
        "offerId": 1,
        "comments": [
            "first com",
            "second com",
            "third com"
        ],
        "active": true,
        "delay_time": 0,
        "creationTime": 1539459825994,
        "expirationTime": null,
        "products": []
    }


````

### PUT to create an offer with specific delay time 

- URL is `http://localhost:2222/worldpay/product/add`

Examples of returned JSONs:


````
 {
        "comments": [
            "first5 com",
            "second5 com",
            "third5 com"
        ],
        "active": true,
        "delay_time": 30,
        "creationTime": null,
        "expirationTime": null,
        "products": []
    }
````
