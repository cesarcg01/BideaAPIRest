
CREATE TABLE public.booking
(
    id character varying(10) NOT NULL ,
    name character varying(50) NOT NULL ,
    lastname character varying(50) NOT NULL ,
    age integer  NOT NULL ,
    phone_number character varying(20) NOT NULL ,
    start_date character varying(20) NOT NULL ,
    end_date character varying(20) NOT NULL ,
    house_id character varying(15) NOT NULL ,
    discount_code character varying(8) ,
    CONSTRAINT pk_booking PRIMARY KEY (id)
);

