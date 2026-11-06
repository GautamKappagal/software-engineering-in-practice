# Order API contract

All response bodies are JSON and use `Content-Type: application/json`.
Order IDs are strings assigned by the service.

## `POST /orders`

Creates an order.

**Request body:**

```json
{"items": ["Burger", "Fries"]}
```

`items` must be a non-empty list and every entry must be a non-empty
string.

**Responses:**

- `201 Created` — the order was created. Body:

  ```json
  {"order_id": "1", "items": ["Burger", "Fries"], "status": "received"}
  ```

- `400 Bad Request` — the request body is not valid JSON. Body:

  ```json
  {"error": "invalid JSON"}
  ```

- `400 Bad Request` — `items` is absent, is not a list, or is an empty
  list. Body:

  ```json
  {"error": "items must be a non-empty list"}
  ```

- `400 Bad Request` — one or more entries in `items` is not a string or
  is an empty string. Body:

  ```json
  {"error": "each item must be a non-empty string"}
  ```

## `GET /orders/{id}`

Returns the order whose ID is in the path.

**Request body:** none.

**Responses:**

- `200 OK` — an order with `{id}` exists. Body:

  ```json
  {"order_id": "1", "items": ["Burger", "Fries"], "status": "received"}
  ```

- `404 Not Found` — no order has the requested ID. Body:

  ```json
  {"error": "order not found"}
  ```

## Unknown path or unsupported method

Any request that does not match `POST /orders` or `GET /orders/{id}`
returns:

- `404 Not Found` — the requested route does not exist. Body:

  ```json
  {"error": "not found"}
  ```