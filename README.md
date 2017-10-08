# ReportGenerationRepo
<html>
<head><b>List of Assumptions</b></head>
<body>
  <ol>
    <li>Each entity gives an instruction to Buy or Sell a share to JP Morgan. These instructions are considered as transactions.</li>
    <li>Same entity can make multiple transactions.</li>
    <li>If there are multiple transactions then the amount should be added for each type of transaction for a single entity, for example, if “foo” tell to Buy in one transaction resulting in amount $100 and then another transaction is made by “foo” with different settlement date to Buy shares of $200 then the total outgoing amount for “foo” will be $300.</li>
    <li>The total outgoing settled amount for the day is the sum of outgoing amount for today.</li>
    <li>The total incoming settled amount for the day is the sum of incoming amount for today.</li>
    <li>All ranks need to be displayed irrespective of the settlement day. Ranks are only based on the total amount outgoing or incoming from an entity.</li>
  </ol>
</body>
</html>
