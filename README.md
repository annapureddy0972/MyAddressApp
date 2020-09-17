# MyAddressApp
Ravj\J|FV
This is a simple REST API application.

Application exposes a rest end point to fetch a random address in json format
It will read addresses.json file and store it in List and returns a random address everytime when the endpoint is accessed.

Endpoint:
GET:
/randomizer/address

Sample output:
{
    "house": "780",
    "street": "Lynnway",
    "city": "Lynn",
    "postalCode": "1905",
    "country": "United States",
    "countryCode": "USA"
}

Validation:
The addresses will be fetched only from the below 4 countries
USA, Mexico, Canada, Netherlands
