<!--- STARTEXCLUDE --->
# Workshops 📘 Better Reads 📘 !

<img src="img/badge.png?raw=true" width="150" align="right" />

[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/datastaxdevs/workshop-goodreads-clone)
[![License Apache2](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Discord](https://img.shields.io/discord/685554030159593522)](https://discord.com/widget?id=685554030159593522&theme=dark)

> ⚠️ Difficulty: **`Intermediate`, we expect you to already know Java and Spring.**

Learn how to build an app end-to-end application with Spring ecosystem *(boot, mvc, security, data, test, thymeleaf)* and Apache Cassandra™.

## 📋 Table of content

<img src="https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/screenshot.png?raw=true" align="right" width="400px"/>

**MATERIALS**
- [Objectives](#1-objectives)
- [Acknowledgements](#2-acknowledgements)
- [Frequently asked questions](#3-frequently-asked-questions)
- [Materials for the Session](#4-materials-for-the-session)

**LAB1 - Database Setup**
- 1.1 [test](#)
- 1.2 [test](#)

2. [Create your Token](#6-create-astra-token)
3. [Start and setup Gitpod](#7-start-and-setup-gitpod)
8. [Work with CqlSh](#8-work-with-cqlsh)
9. [Load Data with DSBulk](#9-load-data-with-dsbulk)
10. [Use Application as anonymous](#10-use-application-as-anonymous)
11. [Setup Authentication](#11-setup-authentication)
12. [Authenticate and use application](#12-authenticate-and-use-application)
13. [Homeworks](#13-homeworks)

## 1. Objectives

* Discover how to use the following technologies: 
  * **Spring Data:** the Object Mapping layer of Spring
  * **Spring Data Cassandra:** what traps to avoid
  * **Spring Security:** how to handle authentication with OAuth2
  * **Spring MVC:** how to expose REST API and controllers
  * **Spring Webflux:** how to use the new `WebClient`
  * **Thymeleaf:** how to build a user interface with Spring
  * **Spring Test:** How to run tests
  * **Astra DB** (a Database-as-a-service built on Apache Cassandra)
* Han fun with an interactive session

## 2. Acknowledgements

This application has been built based on the work of [**Java Brains**](https://www.youtube.com/channel/UCYt1sfh5464XaDBH0oH_o7Q), a famous youtuber *(500k+ subscribers)*. On his channel you can find the full [*Code with me Series*](https://www.youtube.com/watch?v=LxVGFBRpEFM), 16 episodes for building this application step-by-step. The link to each episode is provided at the end of this readme.

## 3. Frequently asked questions

<p/>
<details>
<summary><b> 1️⃣ Can I run this workshop on my computer?</b></summary>
<hr>
<p>There is nothing preventing you from running the workshop on your own machine, If you do so, you will need the following
<ol>
<li><b>git</b> installed on your local system
<li><b>JDK 8+</b> installed on your local system
<li><b>Maven 3.6+</b> installed on your local system
</ol>
</p>
In this readme, we try to provide instructions for local development as well - but keep in mind that the main focus is development on Gitpod, hence <strong>We can't guarantee live support</strong> about local development in order to keep on track with the schedule. However, we will do our best to give you the info you need to succeed.
</details>
<p/>
<details>
<summary><b> 2️⃣ What other prerequisites are required?</b></summary>
<hr>
<ul>
<li>You will need an enough *real estate* on screen, we will ask you to open a few windows and it does not file mobiles (tablets should be OK)
<li>You will need a GitHub account eventually a google account for the Google Authentication (optional)
<li>You will need an Astra account: don't worry, we'll work through that in the following
<li>As Intermediate level we expect you to know what java and Spring are. 
</ul>
</p>
</details>
<p/>
<details>
<summary><b> 3️⃣ Do I need to pay for anything for this workshop?</b></summary>
<hr>
<b>No.</b> All tools and services we provide here are FREE. FREE not only during the session but also after.
</details>
<p/>
<details>
<summary><b> 4️⃣ Will I get a certificate if I attend this workshop?</b></summary>
<hr>
Attending the session is not enough. You need to complete the homeworks detailed below and you will get a nice badge that you can share on linkedin or anywhere else *(open api badge)*
</details>
<p/>

> [🏠 Back to Table of Contents](#-table-of-content)

## 4. Materials for the Session

It doesn't matter if you join our workshop live or you prefer to work at your own pace,
we have you covered. In this repository, you'll find everything you need for this workshop:

- [Slide deck](/slides/slides.pdf)
- [Discord chat](https://dtsx.io/discord)
- [Questions and Answers](https://community.datastax.com/)
- [Twitch backup](https://www.twitch.tv/datastaxdevs)

----

# 🏁 Start Hands-on

## 5. Database Initialization

#### 5.1 - Create an Astra Account

> **Note**: **Datastax Astra** is a cloud-native, fully managed database-as-a-service (DBaaS) based on Apache Cassandra. It provides a scalable, performant and highly available database solution without the operational overhead of managing Cassandra clusters. Astra supports both SQL and NoSQL APIs, and includes features like backup and restore, monitoring and alerting, and access control. It enables developers to focus on application development while the database infrastructure is managed by Datastax.

- `✅ 5.1.a` - Access [https://astra.datastax.com](https://astra.datastax.com) and register with `Google` or `Github` account

![](https://github.com/DataStax-Academy/cassandra-for-data-engineers/blob/main/images/setup-astra-1.png?raw=true)

#### 5.2 - Create an Astra Token

- `✅ 5.2.a` Locate `Settings` (#1) in the menu on the left, then `Token Management` (#2) 

- `✅ 5.2.b`Select the role `Organization Administrator` before clicking `[Generate Token]`

![](https://github.com/DataStax-Academy/cassandra-for-data-engineers/blob/main/images/setup-astra-2.png?raw=true)

- `✅ 5.2.c` - Copy your token in the clipboard. With this token we will now create what is needed for the training.

![](https://github.com/DataStax-Academy/cassandra-for-data-engineers/blob/main/images/setup-astra-3.png?raw=true)

#### 5.3 - Open your Environment

> **Note**: **Gitpod** is a cloud-based integrated development environment (IDE) that allows developers to build, test and run applications directly in their web browser. It provides preconfigured dev environments for GitHub projects, so developers can start coding immediately without setting up local environment. Gitpod saves time and streamlines the development process.

> `✅ 5.3.a` ↗️ _Right Click and select open as a new Tab..._
>
> [![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/datastaxdevs/workshop-betterreads)

#### 5.4 - Setup Astra CLI

> **Note**:  The **Astra CLI** is a command-line interface (CLI) tool for managing Apache Cassandra databases hosted on Datastax Astra. It allows developers to perform tasks like creating and managing databases, executing Cassandra queries, and managing security and access control. The Astra CLI simplifies database management and provides an alternative to the Astra web interface, enabling automation and integration with other tools and workflows.

- `✅ 5.4.a` **Locate the terminal called `setup` and check that the CLI is available**

```
astra --version
```

> 🖥️ `output`
>
> ```
> $ astra --version
> 0.2.1
> ```

- `✅ 5.4.b` **Trigger the setup command**

```
astra setup
```

> 🖥️ `output`
>
> ```
>     _____            __                  
>    /  _  \   _______/  |_____________    
>   /  /_\  \ /  ___/\   __\_  __ \__  \  
>  /    |    \\___ \  |  |  |  | \// __ \_ 
>  \____|__  /____  > |__|  |__|  (____  /
>          \/     \/                   \/ 
>            Version: 0.2.1
> 
>  -----------------------
>  ---      SETUP      ---
>  -----------------------
> 
> $ Enter an Astra token:
> ```

- `✅ 5.4.c` **Provide your token as asked (starting witg AstraCS:..)**

> 🖥️ `output`
>
> ```
> [OK]    Configuration has been saved.
> [OK]    Enter 'astra help' to list available commands.
> ```

- `✅ 5.4.d` **List your existing Users.**

```bash
astra user list
```

> 🖥️ `output`
>
> ```
> +--------------------------------------+-----------------------------+---------------------+
> | User Id                              | User Email                  | Status              |
> +--------------------------------------+-----------------------------+---------------------+
> | b665658a-ae6a-4f30-a740-2342a7fb469c | cedrick.lunven@datastax.com | active              |
> +--------------------------------------+-----------------------------+---------------------+
> ```

#### 5.5 - Create database

- `✅ 5.5.a` **Create database `workshops` with keyspace `better_reads`**

```bash
astra db create workshops -k better_reads --if-not-exist
```

> 🖥️ `Output`
>
> ```
> [ INFO ] - Database 'workshops' already exist. Connecting to database.
> [ INFO ] - Database 'workshops' has status 'MAINTENANCE' waiting to be 'ACTIVE' ...
>[ INFO ] - Database 'workshops' has status 'ACTIVE' (took 7983 millis)
> ```

| Chunk         | Description     |
|--------------|-----------|
| `db create` | Operation executed `create` in group `db`  |
| `workshops` | Name of the database, our argument |
|`-k better_reads` | Name of the keyspace, a db can contains multiple keyspaces |
| `--if-not-exist` | Flag for itempotency creating only what if needed |

> **Note**: If the database already exist but has not been used for while the status will be `HIBERNATED`. The previous command will resume the db an create the new keyspace but it can take about a minute to execute.
>
> ```
> [OK]    Resuming Database 'com.dtsx.astra.sdk.db.domain.Database@406005b3' ...
> [INFO]  Database 'workshops' has status 'RESUMING' waiting to be 'ACTIVE' ...
> [INFO]  Database 'workshops' has status 'ACTIVE' (took 41466 millis)
> [INFO]  Keyspace  'workshops' already exists. Connecting to keyspace.
> [OK]    Database 'workshops' is ready.
> ```

- `✅ 5.5.b` **Check the status of database `workshops`**

```bash
astra db status workshops
```

> 🖥️ `output`
>
> ```
> [ INFO ] - Database 'workshops' has status 'ACTIVE'
> ```

- `✅ 5.5.c` **Get the informations for your database including the keyspace list**

```bash
astra db get workshops
```

> 🖥️ `output`
>
> ```
> +------------------------+-----------------------------------------+
> | Attribute              | Value                                   |
> +------------------------+-----------------------------------------+
> | Name                   | workshops                               |
> | id                     | 906ef2f2-07d0-472c-add6-fe719cf61d02    |
> | Status                 | ACTIVE                                  |
> | Default Cloud Provider | GCP                                     |
> | Default Region         | us-east1                                |
> | Default Keyspace       | better_reads                            |
> | Creation Time          | 2023-02-20T12:06:21Z                    |
> |                        |                                         |
> | Keyspaces              | [0] better_reads                        |
> |                        |                                         |
> | Regions                | [0] us-east1                            |
> +------------------------+-----------------------------------------+
> ```

[🏠 Back to Table of Contents](#-table-of-content)

#### 5.6 - Create Schema

- `✅ 5.6.a` **Check tables list leveraging `cqlsh`**

```bash
astra db cqlsh workshops -k better_reads -e "describe tables;"
```

> 🖥️ `output`
>
> ```
> <empty>
> ```


- `✅ 5.6.b` **Create tables**

```bash
astra db cqlsh workshops \
   -k better_reads \
   -f /workspace/workshop-betterreads/dataset/schema-ddl.cql
```

> 🖥️ `output`
>
> ```
> [INFO] Secure connect bundles have been downloaded.
> [INFO] Cqlsh is starting, please wait for connection establishment...
> ```

- `✅ 5.6.c` **List tables**

```bash
astra db cqlsh workshops -k better_reads -e "describe tables;"
```

> 🖥️ `output`
>
> ```
> author_by_id  book_by_id  book_by_user_and_bookid  books_by_user
> ```

[🏠 Back to Table of Contents](#-table-of-content)

#### 5.7 - Load Data

- `✅ 5.7.a` **Show content of the CSV File**

```
head -n 10 /workspace/workshop-betterreads/dataset/book_by_id_0.csv 
```

> 🖥️ `output`
>
> ```
> id,author_id,author_names,book_description,book_name,cover_ids,published_date
> OL10000049W,"[\"OL3964979A\"]","[]",,"Le crime organise/quatre films exemplaires","[\"3140091\"]",2009-12-11
> OL10000394W,"[\"OL3965434A\"]","[]",,"Portraits of Illusions","[\"3140733\"]",2009-12-11
> OL10000415W,"[\"OL3965461A\"]","[]",,"Le Berceau du monde","[\"3140790\"]",2009-12-11
> OL10000427W,"[\"OL3965478A\"]","[]",,"La fracture identitaire","[]",2009-12-11
> OL10000471W,"[\"OL3965508A\"]","[]",,"Jamiroquaï de A à Z","[\"3140910\"]",2009-12-11
> OL10001081W,"[\"OL3966201A\"]","[]",,"Contes soufis, tome 1","[\"3142335\"]",2009-12-11
> OL10001150W,"[\"OL3966289A\"]","[]",,"Le prix de la terre","[\"3142514\"]",2009-12-11
> OL10001271W,"[\"OL3966392A\"]","[]",,"Balzac","[\"3142712\"]",2009-12-11
> OL10001538W,"[\"OL3966709A\"]","[]",,"D'affectueuses révérences","[]",2009-12-11
> ```

- `✅ 5.7.b` **Check how many rows. It should have more than 250k**

```
wc -l /workspace/workshop-betterreads/dataset/book_by_id_0.csv
```

> 🖥️ `output`
>
> ```
> 250437 ./dataset/book_by_id_0.csv
> ```

- `✅ 5.7.c` **Populate table `book_by_id` from the csv `book_by_id_0`**

```
astra db load workshops \
     -k better_reads \
     -t book_by_id \
     -maxErrors -1 \
     -url /workspace/workshop-betterreads/dataset/book_by_id_0.csv
```

- The batch is running and should be able to see the throughput at ~3k records per second.

> 🖥️ `output`
>
> ```
> [INFO] Secure connect bundles have been downloaded.
> [INFO] RUNNING: dsbulk load -u token -p xxxxb -b /yyy1.zip -k better_reads -t book_by_id -logDir ./logs --log.verbosity normal --schema.allowMissingFields true -maxConcurrentQueries AUTO -delim , -url ./dataset/book_by_id_0.csv -header true -encoding UTF-8 -skipRecords 0 -maxErrors -1
> [INFO] DSBulk is starting please wait ...
> Username and password provided but auth provider not specified, inferring PlainTextAuthProvider
> A cloud secure connect bundle was provided: ignoring all explicit contact points.
> A cloud secure connect bundle was provided and selected operation performs writes: changing default consistency level to LOCAL_QUORUM.
> ...
>  total | failed | rows/s |  p50ms |  p99ms | p999ms | batches
> 18,944 |      0 |  1,706 | 107.08 | 134.22 | 182.45 |    1.00
> ...
> ```

- The operation should take about 1 minute to complete. The file can have some errors like invalid title with special characters. IT IS NOT A PROBLEM the dataset is not perfect we will have some failed rows.

> 🖥️ `output`
>
> ```
>  total | failed | rows/s | p50ms | p99ms | p999ms | batches
> 250,000 |    183 |  3,684 | 21.44 | 56.10 |  66.32 |    1.00
> Operation LOAD_20220214-185449-001328 completed with 183 > errors in 1 minute and 7 seconds.
> ```

- `✅ 5.7.d` **Populate table `book_by_id` from the csv `book_by_id_1`**

```
astra db load workshops \
     -k better_reads \
     -t book_by_id \
     -maxErrors -1 \
     -url /workspace/workshop-betterreads/dataset/book_by_id_1.csv
```

> 🖥️ `output`
>
> ```
>  total | failed | rows/s |  p50ms |  p99ms | p999ms | batches
> 250,000 |    138 |  1,787 | 106.92 | 136.31 | 398.46 |    1.00
> Operation LOAD_20230220-153154-071483 completed with 138 errors in 2 minutes and 19 seconds.
> ```

- `✅ 5.7.e` **Count Records in the table `book_by_id`**

```
astra db count workshops \
     -k better_reads \
     -t book_by_id \
```

> 🖥️ `output`
>
> ```
> Picked up JAVA_TOOL_OPTIONS:  -Xmx2576m
>  total | failed | rows/s |  p50ms |    p99ms |   p999ms
> 499,679 |      0 | 57,806 | 210.15 | 6,207.57 | 6,207.57
> 
> ```

[🏠 Back to Table of Contents](#-table-of-content)

## 6. Spring Applications

#### 6.1 - Configuration



```
astra db create-dotenv workshops -k better_reads
set -a
source .env
set +a
env | grep ASTRA
```


- It would be handy to know the URL of the application

```
gp url 8080
```

- Start the app

```
cd /workspace/workshop-betterreads/better-reads-webapp
mvn spring-boot:run
```

- Output

```
 ________          __                   __                  ________                     .__                                     
 \______ \ _____ _/  |______    _______/  |______  ___  ___ \______ \   _______  __ ____ |  |   ____ ______   ___________  ______
  |    |  \\__  \\   __\__  \  /  ___/\   __\__  \ \  \/  /  |    |  \_/ __ \  \/ // __ \|  |  /  _ \\____ \_/ __ \_  __ \/  ___/
  |    `   \/ __ \|  |  / __ \_\___ \  |  |  / __ \_>    <   |    `   \  ___/\   /\  ___/|  |_(  <_> )  |_> >  ___/|  | \/\___ \ 
 /_______  (____  /__| (____  /____  > |__| (____  /__/\_ \ /_______  /\___  >\_/  \___  >____/\____/|   __/ \___  >__|  /____  >
         \/     \/          \/     \/            \/      \/         \/     \/          \/            |__|        \/           \/ 

 BetterReads with Spring Boot, String Data, Spring NVC, Spring security
 An application by JabaBrains.
 The application will start at http://localhost:8080


13:37:20.276 INFO  com.datastax.astra.sdk.AstraClient              : Setup of AstraClient from application.yml
13:37:20.280 INFO  com.datastax.astra.sdk.config.AstraClientConfig : Initializing [AstraClient]
13:37:20.459 INFO  com.datastax.astra.sdk.AstraClient              : + API(s) Devops     [ENABLED]
13:37:20.459 INFO  com.datastax.astra.sdk.AstraClient              : + Db: id [3ed83de7-d97f-4fb6-bf9f-82e9f7eafa23] and region [eu-west-1]
13:37:20.460 INFO  com.datastax.astra.sdk.AstraClient              : + Downloading bundles in: [/home/gitpod/.astra]
13:37:21.124 INFO  com.datastax.astra.sdk.databases.DatabaseClient : + SecureBundle found : scb_3ed83de7-d97f-4fb6-bf9f-82e9f7eafa23_eu-west-1.zip
13:37:21.124 INFO  com.datastax.astra.sdk.databases.DatabaseClient : + SecureBundle found : scb_3ed83de7-d97f-4fb6-bf9f-82e9f7eafa23_eu-central-1.zip
13:37:23.041 INFO  com.datastax.astra.sdk.AstraClient              : [AstraClient] has been initialized.
```

- Open a new terminal (yes a 3rd one again, 2 previous are busy, same icon) and enter the command.

```
gp preview $(gp url 8080)
```

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/app1.png?raw=true)

- In the search item look for `Glimpses of ancient Sowams` you can search to whatever you want it will request open library ut during this workshop you only imported a subset of books, let us pick one you imported.

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/app2.png?raw=true)

- Select the first item, if you select the second you will hit the page book not found as this book is not in the DB.

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/app3.png?raw=true)

This is only what we can do at this point. To mark the book as read we will need to authenticate with `Google` or `Github`.


[🏠 Back to Table of Contents](#-table-of-content)

## 11. Setup Authentication

### ✅ 11a. Setup Google OAuth2 (optional)

- Connect to [Google Cloud Platform](https://console.cloud.google.com)

- Create a new project if needed, on the screens i put `BetterReadsDemoApps` and click `[CREATE]]`

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/gcp1.png?raw=true)

- Select `[ENABLE APIS AND SERVICES]` in menu

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/gcp2.png?raw=true)

- Search for Gmail and Google Analytics Apis and add them to your project.

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/gcp3.png?raw=true)

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/gcp4.png?raw=true)

- Select `[OAuth consent screen]` in the menu on the left. Provide your application name, a support email and the application logo.

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/gcp5.png?raw=true)

- Check `External` (or internal as you prefer to limit scope).

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/gcp6.png?raw=true)

- On menu in the left select *Credentials* and use the button on top `[CREATE CREDENTIALS]`/ OAuth ClientID.

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/gcp7.png?raw=true)

- Select `Web Application` and provide it a name

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/gcp8.png?raw=true)

- Add the URL home page. It will the result of `gp url 8080` command on gitpod or *http://localhost:8080* if you work locally.

**The screenshots below show `Google` authentication when the app is running on `localhost`. Carefully adjust the URLs accordingly to the Gitpod URL when application is running on Gitpod.**

- Add the redirect *http://localhost:8080/login/oauth2/code/google* if you work locally or the result of `echo $(gp url 8080)/login/oauth2/code/google` on gitpod.

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/gcp9.png?raw=true)

- A new page will open with your `clientId` and `client Secret`. Make sure you copy them locallym you will need to setup your application with it.

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/gcp10.png?raw=true)

```
You are now doomed we will now mine cryptos with your google account.

Just kidding ^_^
``` 

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/gcp11.png?raw=true)

- Open file `src/main/resources/application.yml` in your project

```
gp open /workspace/workshop-betterreads/better-reads-webapp/src/main/resources/application.yml
```

- Changes keys `client-id` and `client-secret` with your values for the provider `Google`.

```yaml
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: change
            client-secret: change
```


### ✅ 11b. Setup up Github

As each attendee has a different URL in gitpod, you will have to create your own github `OAuth Apps - Let's do this together.

- For github settings we will have to enter a callback URL. To know which one enter use the following command

```
clear
echo $(gp url 8080)/login/oauth2/code/github
```

- Login to your github account and go to `Organizations`

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/githubapps1.png?raw=true)

- There scroll down to locate the last item of the menu `Developer Settings` *(hopefully you have not as many organizations as me)*, There pick `OAuth Apps` (we are using OAuth)

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/githubapps2.png?raw=true)

- Click button `[New OAuth Apps]` on the page

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/githubapps3.png?raw=true)

- You will be asked to login again for security reasons, then fill the form to register a new Github App. Thre Register your application

|Name| Value|
|---|---|
| `Application name`| The application name shown to user |
| `Homepage URL`| Can be anything, just the app (gp url 8080) |
| `Authorization Callback URL`| Call back url the one listed above `${homepage}/login/oauth2/code/github` |

- Click `[Register Application]`

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/githubapps4.png?raw=true)

- The application is created. You got your clientId. You will have to generate a clientSecret now. Once you get both save them on a text file in your machine we will need them later

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/githubapps5.png?raw=true)

- When everything is set you can upload am image for your application and save the change with `[Update Application]`.

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/githubapps6.png?raw=true)
 
- Open `application.yml`

- Open file `src/main/resources/application.yml` in your project

```
gp open /workspace/workshop-betterreads/better-reads-webapp/src/main/resources/application.yml
```

- Changes keys `client-id` and `client-secret` with your values for the provider `Github`.

```yaml
  security:
    oauth2:
      client:
        registration:
          github:
            client-id: change
            client-secret: change
```


[🏠 Back to Table of Contents](#-table-of-content)

## 12. Authenticate and use application

- After setting up the connection you can now start the application again :

```
cd /workspace/workshop-betterreads/better-reads-webapp
mvn spring-boot:run
```

### ✅ 12a. Authenticate with Github

- On homepage click on `Authenticate with Github`

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/githubapps7.png?raw=true)

- Eventually you get the SSO screen for you organization

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/githubapps8.png?raw=true)

- Then you authorize the application again

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/githubapps9.png?raw=true)

```
HAHAHA EVIL LAUGH 

YOU ARE DOOMED AGAIN WE ALSO HAVE YOUR GITHUB ACCOUNT NOW
WE WILL FEED OUR TROLLS AND CODEX.AI WITH IT.
```

- More seriously, Your are in !

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/githubapps10.png?raw=true)

### ✅ 12b. Authenticate with Google.

- Use the button `[Login via Google]`

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/google1.png?raw=true)

- Validate with the familiar Google Screen

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/google2.png?raw=true)

- You are in !

![new_terminal](https://github.com/datastaxdevs/workshop-betterreads/blob/master/img/google3.png?raw=true)

[🏠 Back to Table of Contents](#-table-of-content)

## 13. Homeworks

<img src="img/badge.png?raw=true" width="200" align="right" />

Don't forget to complete your assignment and get your verified skill badge! Finish and submit your homework!

1. Complete the practice steps as described below until you have your own app running in Gitpod. (up to step 11)
2. Answer the technical questions in the form (We promise, it is NOT difficult if you follow the workshop).
3. Take a screenshot of you authenticated in the app with a few books
4. Submit your homework [here](https://dtsx.io/homework-betterreads)

5. *(totally optional)* Watch the full course on Javabrains.io

- [01 - Introduction to the series](https://www.youtube.com/watch?v=LxVGFBRpEFM)
- [02 - About the app](https://www.youtube.com/watch?v=HAiCwq4jfn8)
- [03 - System Design](https://www.youtube.com/watch?v=SnQXdvFkq4U)
- [04 - Cassandra Schema](https://www.youtube.com/watch?v=106jIBE9XSc)
- [05 - Setting up hosted](https://www.youtube.com/watch?v=waLSHx-VN08)
- [06 - Creating the Data Loader](https://www.youtube.com/watch?v=d28t_QySyzs)
- [07 - Connecting Spring Boot app to DataStax Astra](https://www.youtube.com/watch?v=7I37-awpaGg)
- [08 - Using Repository pattern with Spring Data](https://www.youtube.com/watch?v=uezZIPK8kPk)
- [09 - Saving all the authors in the world to Cassandra](https://www.youtube.com/watch?v=24NrLl8EhDM)
- [10 - Setting up books by ID ](https://www.youtube.com/watch?v=Fm-XrOTgOto)
- [11 - Starting with Spring boot and security](https://www.youtube.com/watch?v=nwyf_4aSkqM)
- [12 - Implementing the Book view flow](https://www.youtube.com/watch?v=-IuafzgS3fU)
- [13 - Building book search feature](https://www.youtube.com/watch?v=6K0im9vcoCk)
- [14 - Tracking user interactions with books](https://www.youtube.com/watch?v=NEZGCpN1J6M)
- [15 - Building the My Books feature](https://www.youtube.com/watch?v=ZIGImCqRr1I)
- [16 - Wrapping Up](https://www.youtube.com/watch?v=hJLtsn2aSr4)

----
