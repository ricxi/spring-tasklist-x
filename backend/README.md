# backend
Things I need to do
* enable CORS
* custom exceptions
* more validation
* testing
* fix update task feature ("Complete" is automatically set to false when its JSON field is not provided)

## nots
* For **creating** a new task, an error is thrown when an (1) empty string is provided in the **subject** field or (2) the **subject** field is missing completely. However, when updating a task, for the above two cases, no error is thrown and the subject field is not updated. Does this functionality make sense?a
* **BUG** For **updating** an existing task, if not "complete" field is provided in the JSON, it will be reset to false in the database.