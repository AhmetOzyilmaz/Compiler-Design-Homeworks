read n;
next := 0;
first := 0;
second := 1;
c := 0;
repeat
if c < 1 then
next := c;
end
if c = 1 then
next := c;
else
next := first + second;
first := second;
second := next;
end
c := c + 1;
write next;
until c = n;
read x;
if x < 32 then
fact := 1;
repeat
fact := fact * x;
x := x - 1;
until x = 0;
write fact;
end