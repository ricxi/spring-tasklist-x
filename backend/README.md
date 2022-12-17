# backend
Things I need to do
* enable CORS
* more validation
* testing
* better exception handling classes?
* more exception handling classes?
* fix update task feature ("Complete" is automatically set to false when its JSON field is not provided)

## notes
* how do I validate path parameters? How do I check that I received an id path variable?
* Instead spending all day thinking about how to structure this project, I think what's important right now is learning how to use Spring Boot better. There are so many styles DDD, CQRS, etc.. and so much more reading and research. Yes, these are important concepts, which I would like to study and read up on eventually. But they are also things that require a good portion of time where I won't be coding. First, understand spring boot well, then work on the details. But at the same time, those are a case by case basis, and different organizations will have different standards.
* For **creating** a new task, an error is thrown when an (1) empty string is provided in the **subject** field or (2) the **subject** field is missing completely. However, when updating a task, for the above two cases, no error is thrown and the subject field is not updated. Does this functionality make sense?a
* **BUG** For **updating** an existing task, if not "complete" field is provided in the JSON, it will be reset to false in the database.