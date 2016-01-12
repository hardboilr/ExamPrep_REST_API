#Notes

Question 3) If you have time create an HTML page that could fetch and show data (using JQuery or Angular) for some of the methods created above.

Can still add more stuff to the frontend.

Look into scalar vs. non-scalar values.

#General part

>Elaborate on some of the characteristics of REST, like: Stateless, Cacheable, Layered System, Uniform Interface etc.

REST: REpresentational State Transfer

Stateless:
Every resource that is accessed via HTTP is a single request with no threaded connection between them. The URI uniquely identifies the resource and the body contains the state (or state change) of that resource. Then after the server does it's processing, the appropriate state are communicated back to the client via headers, status and response body.

In REST, the client must include all information for the server to fulfill the request, resending state as necessary if that state must span multiple requests. Statelessness enables greater scalability since the server does not have to maintain, update or communicate that session state.

From slides:
1) REST interactions store no client context on the server between requests.
2) The client holds session state.
3) All information necessary to service the request is contained in the URL, query parameters, body or headers.

Cacheable:
As on the World Wide Web, clients can cache responses. Responses must therefore, implicitly or explicitly, define themselves as cacheable, or not, to prevent clients reusing stale or inappropriate data in response to further requests. Well-managed caching partially or completely eliminates some client–server interactions, further improving scalability and performance.

From slides:
1) Clients can cache the responses. The responses must define themselves as, cacheable or not, to prevent the client from sending the inappropriate data in response to further requests.


Layered System:
A client cannot ordinarily tell whether it is connected directly to the end server, or to an intermediary along the way. Intermediary servers may improve system scalability by enabling load-balancing and by providing shared caches. Layers may also enforce security policies.

From slides:
1) The clients and the server are separated from each other.
2) The client is not concerned with the data storage thus the portability of the client code is improved
3) The server is not concerned with the client interference, thus the server is simpler and easy to scale.

What clients see: XML, JSON, HTML, Plain text etc.
What servers see: Classes, Language Data Structures, Business Logic, Database Tables, Exceptions etc.

Uniform Interface:
The uniform interface constraint defines the interface between clients and servers. It simplifies and decouples the architecture, which enables each part to evolve independently. This separation of concerns means that, for example, clients are not concerned with data storage, which remains internal to each server, so that the portability of client code is improved. Servers are not concerned with the user interface or user state, so that servers can be simpler and more scalable.

Think endpoints and api-documentation describing how to use api and how to ask for or manipulate data on server.
POST, DELETE, GET and PUT.

Sources: 
http://www.restapitutorial.com/lessons/whatisrest.html#
http://stackoverflow.com/questions/4913763/what-does-it-mean-when-they-say-http-is-stateless

>Elaborate on how JSON or XML supports communication between subsystems, even when the subsystems are implemented on different platforms.
Not sure if I understand the full extent of this question...

When one chooese a shared/uniform data-protocol such as json or xml you then only expose that json-data and nothing else. They subsystems does not care from which platform is has received the json or where it will send it, as long as the json-data are correctly formatted.

>Explain the purpose of Object Relational Mapping (ORM), and import JPA topics

ORM means is a way to interact with relational databaseses using object oriented programming languages. Basically you can work with data as objects containing attributes as you would ordinarily do and then the API would take care of mapping that data to relational tables in the database. Properly used and ORM will give the developers the benefits of using OO-language and relational databases.

ORM pros:
1) Reduces amount of code 
2) Avoids low level JDBC and SQL code
3) Provides database and schema independence
4) It allows us to use the OO-paradigm

ORM cons:
1) High level of abstraction (we don't know what actually happens)
2) Can result in poorly designed databases (normalforms)

Java Persistence API is such an interface. 

JPQL: Query language allows us to write portable queries that work regardless of the underlying data store. Meaning that we have abstracted away from Oracle SQL query or mySQL query syntax.

Entities: An entity is a domain object and represents a table in a database. Each entity instance corresponds to a row in that table. Must as a minimum have an attribute with an @Id-tag (primary key).  
