# HumanAPI Java client

## Usage

1) Create client instance:

```
HumanAPIClient client = new HumanAPIClient();
```
Access token for HumanAPI will be taken from `HUMANAPI_ACCESS_TOKEN` environment variable.

If you want to pass token from your own code, then use parameterized constructor:

```
HumanAPIClient client = new HumanAPIClient(myAccessToken);
```

2) Fetch the entity from the `client` and call required method, for example:

```
client.humanEntity().get()
```

See class documentation or source to find all `*Entity()` methods and available methods for each entity class.

Every method return generic JSON data wrapper into `JSONObject` or `JSONArray` object.

## Tests

TestNG classes can be run with Maven. Access token is passed via environment variable. Other token value can be passed but most likely tests will fail because they are partially based on content of the `demo` token user.

```
HUMANAPI_ACCESS_TOKEN=demo mvn test
```

