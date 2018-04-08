Div info om postgres stored procedures

Example

CREATE FUNCTION devdev.addingstuff(p1 integer, p2 integer)
 RETURNS integer AS
$BODY$BEGIN
RETURN p1 + p2;
END;$BODY$
LANGUAGE PLPGSQL;


For å kalle den

select devdev.addingstuff(5, 8);
