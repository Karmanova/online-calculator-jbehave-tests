Scenario: Acceptance Scenario using UI keys
Given Start page of Online Calculator in browser
When User types expression 1+2*3 using user interface
When User applies the + operation by 1
When put a tmp of 10 in TEMP
When get a variable of tmp in TEMP
When User applies the operation Ctrl + C
When User press the buton C
When User applies the operation Ctrl + V
When User types expression = using user interface
Then The result of an int type 8

Scenario: 1. Acceptance Scenario "CopyPaste"
Given Start page of Online Calculator in browser
When User types expression 1+2-3*4/5+6-7*8/9+0 using user interface
When User applies the operation Ctrl + C
When User press the buton C
When User applies the operation Ctrl + V
When User types expression = using user interface
Then The result of an double type  0.3777777777777773

Scenario: 2. Acceptance Scenario "NonStandartValue"
Given Start page of Online Calculator in browser
When User types expression  1000000 - 3009 using user keyboboard
When User types expression = using user interface
When User applies the / operation by 0
When User types expression = using user interface
When User applies the / operation by -Infinity
When User types expression = using user interface
When User applies the + operation by 2005
When User types expression = using user interface
When User applies the + operation by NaN
When User types expression = using user interface
Then The result of an String type NaN

Scenario: 3. Acceptance Scenario "ArithmeticOperation"
Given Start page of Online Calculator in browser
When User types expression  (0.1 + 0.2) * 0.3 using user keyboboard
When User types expression = using user interface
When User applies the ^ operation by 2
When User types expression = using user interface
When User applies the + operation by 1000000
When User types expression = using user interface
When User applies the + operation by 0,1
When User types expression = using user interface
Then The result of an double type 1000000.1081

Scenario: 4. Acceptance Scenario "UnaryOperation"
Given Start page of Online Calculator in browser
When User applies the - operation by 1
When User types expression = using user interface
Then The result of an int type -1

When User types expression  ((1+1))) using user keyboboard
When User types expression = using user interface
Then The result of an String type Error

Scenario: 6. Acceptance Scenario "UI"
Given Start page of Online Calculator in browser
When User types expression 1+2-3*4/5+6-7 using user interface
When User types expression *8+9+0 using keyboard
When User types expression = using user interface
Then The result of an double type  0.3777777777777773
When User press the buton C
Then The result of an String type ""

Scenario: 7. Acceptance Scenario "KeyboardInsert"
Given Start page of Online Calculator in browser
When User types expression  1+2-3*4/5+6-7*8+9+0 using user keyboboard
When User types expression = using user interface
When User types expression  +(sin(90))^2 using keyboard
When User types expression = using user interface
Then The result of an String type Error

Scenario: 8. Acceptance Scenario "HardFun"
Given Start page of Online Calculator in browser
When User types expression  sin(90) using user keyboboard
When User types expression = using user interface
Then The result of an int type 1
When User types expression  +(sin(90))^2 using user keyboboard
When User types expression = using user interface
Then The result of an int type 2
When User applies the operation Ctrl + C
When User press the buton C
When User types expression  ln( using user keyboboard
When User applies the operation Ctrl + V
When User types expression  ) using user keyboboard
When User types expression = using user interface
When User applies the ^ operation by 3
When User types expression = using user interface
Then The result of an double type 0.33302465198

Scenario: 9. Acceptance Scenario "Domain"
Given Start page of Online Calculator in browser
When User types expression  1000000 - 3009 using user keyboboard
When User types expression = using user interface
When User types expression +3009 using keyboard
When User types expression = using user interface
When User types expression  -1+3009 using user interface
When User types expression = using user interface
Then The result of an String type Error








