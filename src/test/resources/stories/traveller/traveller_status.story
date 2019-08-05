Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: traveller example
Meta:
@tags branch:develop,scope:autosmoke
When the traveller files
Then the traveller should have a status of <EXPECTED_STATUS>

Examples:
data/trades.table