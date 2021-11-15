
### URLs for the API


##API to add the bill
```
curl --location --request POST 'http://35.200.152.4:7070/addBill' \
--header 'Content-Type: application/json' \
--data-raw '{
"billTo": "Papa",
"price": 848.50,
"date": "15-02-2021",
"tax": 221.0
}'
```
###Response
```
{
    "id": 4,
    "billTo": "Papa",
    "price": 848.5,
    "date": "Mon Feb 15 00:00:00 IST 2021",
    "tax": 221.0,
    "total": 1069.5
}
```

##API to get the bills
```
curl --location --request GET 'http://35.200.152.4:7070/bills'
```

###Response
```
[
    {
        "id": 1,
        "billTo": "Papa",
        "price": 848.5,
        "date": "2021-02-14T18:30:00.000+00:00",
        "tax": 221.0,
        "totalAmount": 1069.5
    },
    {
        "id": 2,
        "billTo": "Anish",
        "price": 848.5,
        "date": "2021-02-24T18:30:00.000+00:00",
        "tax": 221.0,
        "totalAmount": 1069.5
    },
    {
        "id": 3,
        "billTo": "subho",
        "price": 848.5,
        "date": "2021-02-14T18:30:00.000+00:00",
        "tax": 221.0,
        "totalAmount": 1069.5
    }
]
```

##API to get the bill using its ID
```
curl --location --request GET 'http://35.200.152.4:7070/bills/1'
```

###Response
```
{
    "id": 1,
    "billTo": "Papa",
    "price": 848.5,
    "date": "2021-02-14T18:30:00.000+00:00",
    "tax": 221.0,
    "totalAmount": 1069.5
}
```

##API to get the bill by using the due date
```
curl --location --request GET 'http://35.200.152.4:7070/bills/due/15-02-2021'
```
###Response
```
[
  {
    "id": 1,
    "billTo": "Papa",
    "price": 848.5,
    "date": "2021-02-14T18:30:00.000+00:00",
    "tax": 221,
    "totalAmount": 1069.5
  },
  {
    "id": 3,
    "billTo": "subho",
    "price": 848.5,
    "date": "2021-02-14T18:30:00.000+00:00",
    "tax": 221,
    "totalAmount": 1069.5
  }
]
```
