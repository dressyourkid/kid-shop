# Kid shop

[![Build Status](https://travis-ci.org/dressyourkid/kid-shop.svg?branch=master)](https://travis-ci.org/dressyourkid/kid-shop)

## Profiles
Use `dev` or `test` profile to up the app with `CORS` support allowed for all origins and without `CSRF`

## Unit testing

To write a simple test based on spring-test application context extend the `ApplicationTest.class`  
Example:  
```java
public class BasketRepositoryTest extends ApplicationTest {
    // Inject beans and do some stuff
}
```
To test Rest api e.g. controllers via `MockMvc` extend `ControllerDocumentedTest`  
Example: 
```java
public class StoreControllerTest extends ControllerDocumentedTest {
    @Test
    public void testGetStore() {
        // mockMvc already autowired
        mockMvc.perform(get("/store/1000"))
                        .andDo(print())
                        .andExpect(status().isOk());
        // Also spring rest-docs available here
    }
}
```
