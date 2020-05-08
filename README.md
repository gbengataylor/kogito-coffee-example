Kogito docs -  https://docs.jboss.org/kogito/release/latest/html_single/#chap-kogito-creating-running

to test locally, run the following in each
dir
```
mvn quarkus:dev
```

coffee-service will run locally on port 8090 and coffeeshop on 8080. go to localhost:/8080/swagger-ui to test the POST /coffeeprocess API

to deplooy coffee REST to openshift
```
mvn clean package -Dquarkus.kubernetes.deploy=true
```
if image was built but DC failed to deploy
```
oc new-app coffeeservice-quarkus:1.0-SNAPSHOT
oc expose service coffeeservice-quarkus
oc label dc/coffeeservice-quarkus app.openshift.io/runtime=java --overwrite 
```

FROM GIT
```
oc new-app registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift~https://github.com/gbengataylor/kogito-coffee-example.git --context-dir=coffeeservice-quarkus --name=coffeeservice-quarkus 

```

to deploy coffeeshop kogito process to OCP

you can install the kogito operator to openshift, then create a KogitoApp CR that references the git repo/context dir

OR use the kogito cli
```
kogito new-project kogito-operator-lab-user1
#if project is already created
kogito use-project kogito-operator-lab-user1
kogito deploy-service coffeeshop https://github.com/gbengataylor/kogito-coffee-example --context-dir coffeeshop
```

FROM source
```
oc start-build coffeeshop --from-dir=target/
```
