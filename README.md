## Commands

```bash
docker-compose build
```

```bash
docker-compose up
```

# To access the API using curl:

```bash
# Get all posts
curl http://localhost:8080/posts

# Create a new post
curl -X POST -H "Content-Type: application/json" -d '{"title": "Hello", "content": "This is a new post."}' http://localhost:8080/posts

# Update a post (replace {id} with the actual post ID)
curl -X PUT -H "Content-Type: application/json" -d '{"title": "Updated title", "content": "This is the updated content."}' http://localhost:8080/posts/{id}

# Delete a post (replace {id} with the actual post ID)
curl -X DELETE http://localhost:8080/posts/{id}
```
