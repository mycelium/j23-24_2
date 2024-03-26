## Java core tasks

**1. JSON parser**

- Do not use external libraries
- Read JSON string
  - To Java Object
  - To Map<String, Object>
  - *To specified class*
- Convert Java object to JSON string
- Library should support
  - Classes with fields (primitives, boxing types, null, arrays, classes)
  - Arrays
  - Collections
- Limitations (you may skip implementation)
  - Cyclic dependencies
  - non-representable in JSON types

**2. HTTP Server**

- Do not use external libraries
- Implement part of HTTP 1.1 protocol using ServerSocketChannel (java.nio)
- Methods:
  - GET
  - POST
  - PUT
  - PATCH
  - Delete 
- Headers (should be accesible as Map)
- Body
  - Bonus: multipart form data
- Your library should support:
  - Create and httpserver on specified host+port
  - Add listener to specific path and method
  - Access to request parameters (headers, method, etc)
  - Create and send http response back
