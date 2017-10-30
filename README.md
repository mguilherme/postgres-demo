# Postgres Demo
Spring Boot with Postgres and jsonb support.
Column `info` from `table` users will contain:

```json
{
  "ttl": 3,
  "notes": "This is a test note",
  "luckyNumbers": [
    3,
    5,
    6
  ],
  "additionalInfo": {
    "content": "My additional info."
  }
}
```