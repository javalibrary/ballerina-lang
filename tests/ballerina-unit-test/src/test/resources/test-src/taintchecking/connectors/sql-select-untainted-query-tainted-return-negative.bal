import ballerina/mysql;

type Employee record {
    int id;
    string name;
};

public function main(string... args) {
    testSelectWithUntaintedQueryProducingTaintedReturnNegative(...args);
}

public function testSelectWithUntaintedQueryProducingTaintedReturnNegative(string... args) {
    endpoint mysql:Client testDB {
        host:"localhost",
        port:3306,
        name:"testdb",
        username:"root",
        password:"root",
        poolOptions:{maximumPoolSize:5}
    };

    var output = testDB->select("SELECT  FirstName from Customers where registrationID = 1", ());
    match output {
        table dt => {
            while (dt.hasNext()) {
                var rs = <Employee>dt.getNext();
                match rs {
                    Employee emp => testFunction(emp.name);
                    error => return;
                }
            }
        }
        error => return;
    }
    testDB.stop();
    return;
}

public function testFunction(@sensitive string anyValue) {

}

