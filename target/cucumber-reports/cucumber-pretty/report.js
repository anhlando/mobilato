$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Cashloan/test.feature");
formatter.feature({
  "line": 1,
  "name": "Test",
  "description": "",
  "id": "test",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Test",
  "description": "",
  "id": "test;test",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I open HCNV app",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I do sth",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.iOpenHCNVApp()"
});
formatter.result({
  "duration": 10417342885,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iDoSth()"
});
formatter.result({
  "duration": 950042,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat steps.MyStepdefs.iDoSth(MyStepdefs.java:45)\r\n\tat ✽.And I do sth(Cashloan/test.feature:6)\r\n",
  "status": "pending"
});
});