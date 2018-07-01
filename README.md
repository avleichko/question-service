# Project Title

Search service ui, this service provides ui(landing page) for search service.
It sends ajax requests from ui to search service.
## Supporting features 
* upload file by key (file name) to remote storage
* download file from storage by given key (file name)
* search text in all stored files, returns files names if all search elements were found in particular file

## Getting Started

```

cd <your_path_to>/searchservice-ui
mvn clean install
java -jar ui-0.0.1-SNAPSHOT.jar

in your browser please open 
localhost:8080
```

### Prerequisites


```
java >= 1.8
mvn >= 3.5.3

```

## limitations

```
ui sends data to remote service. 
This service can work only with csv files .
file size needs to be less then 30mb.
thiese limitations could be changed on serach service side (update application.yml required)

```


## Authors

* **Aleksandr Velichko** - *email* - [mrdezzdemon@gmail.com](mrdezzdemon@gmail.com)
