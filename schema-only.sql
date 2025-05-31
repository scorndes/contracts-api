--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: address; Type: TABLE; Schema: public; Owner: scorne
--

CREATE TABLE public.address (
    id integer NOT NULL,
    user_id uuid,
    principale boolean NOT NULL,
    numero integer NOT NULL,
    ligne_1 character varying(100) NOT NULL,
    ligne_2 character varying(100),
    code_postal character varying(10) NOT NULL,
    ville character varying(50) NOT NULL,
    pays character varying(50) NOT NULL
);


ALTER TABLE public.address OWNER TO scorne;

--
-- Name: address_id_seq; Type: SEQUENCE; Schema: public; Owner: scorne
--

CREATE SEQUENCE public.address_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.address_id_seq OWNER TO scorne;

--
-- Name: address_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: scorne
--

ALTER SEQUENCE public.address_id_seq OWNED BY public.address.id;


--
-- Name: asset_categories; Type: TABLE; Schema: public; Owner: scorne
--

CREATE TABLE public.asset_categories (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.asset_categories OWNER TO scorne;

--
-- Name: asset_categories_id_seq; Type: SEQUENCE; Schema: public; Owner: scorne
--

CREATE SEQUENCE public.asset_categories_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.asset_categories_id_seq OWNER TO scorne;

--
-- Name: asset_categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: scorne
--

ALTER SEQUENCE public.asset_categories_id_seq OWNED BY public.asset_categories.id;


--
-- Name: asset_classes; Type: TABLE; Schema: public; Owner: scorne
--

CREATE TABLE public.asset_classes (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    category_id integer
);


ALTER TABLE public.asset_classes OWNER TO scorne;

--
-- Name: asset_classes_id_seq; Type: SEQUENCE; Schema: public; Owner: scorne
--

CREATE SEQUENCE public.asset_classes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.asset_classes_id_seq OWNER TO scorne;

--
-- Name: asset_classes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: scorne
--

ALTER SEQUENCE public.asset_classes_id_seq OWNED BY public.asset_classes.id;


--
-- Name: portfolio_asset_classes; Type: TABLE; Schema: public; Owner: scorne
--

CREATE TABLE public.portfolio_asset_classes (
    portfolio_id uuid NOT NULL,
    asset_class_id integer NOT NULL,
    percentage float NOT NULL
);


ALTER TABLE public.portfolio_asset_classes OWNER TO scorne;

--
-- Name: portfolios; Type: TABLE; Schema: public; Owner: scorne
--

CREATE TABLE public.portfolios (
    id uuid NOT NULL,
    user_id uuid,
    name character varying(100) NOT NULL,
    risk_profile_id integer,
    stocks float NOT NULL,
    bonds float NOT NULL,
    created_at timestamp without time zone NOT NULL
);


ALTER TABLE public.portfolios OWNER TO scorne;

--
-- Name: risk_profiles; Type: TABLE; Schema: public; Owner: scorne
--

CREATE TABLE public.risk_profiles (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    min_bonds float NOT NULL
);


ALTER TABLE public.risk_profiles OWNER TO scorne;

--
-- Name: risk_profiles_id_seq; Type: SEQUENCE; Schema: public; Owner: scorne
--

CREATE SEQUENCE public.risk_profiles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.risk_profiles_id_seq OWNER TO scorne;

--
-- Name: risk_profiles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: scorne
--

ALTER SEQUENCE public.risk_profiles_id_seq OWNED BY public.risk_profiles.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: scorne
--

CREATE TABLE public.users (
    id uuid NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(100) NOT NULL,
    lastname character varying(50) NOT NULL,
    firstname character varying(50) NOT NULL,
    birthname character varying(50),
    birthdate timestamp without time zone NOT NULL,
    email character varying(100) NOT NULL,
    role character varying(50) DEFAULT 'ROLE_USER'::character varying NOT NULL
);


ALTER TABLE public.users OWNER TO scorne;

--
-- Name: address id; Type: DEFAULT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.address ALTER COLUMN id SET DEFAULT nextval('public.address_id_seq'::regclass);


--
-- Name: asset_categories id; Type: DEFAULT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.asset_categories ALTER COLUMN id SET DEFAULT nextval('public.asset_categories_id_seq'::regclass);


--
-- Name: asset_classes id; Type: DEFAULT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.asset_classes ALTER COLUMN id SET DEFAULT nextval('public.asset_classes_id_seq'::regclass);


--
-- Name: risk_profiles id; Type: DEFAULT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.risk_profiles ALTER COLUMN id SET DEFAULT nextval('public.risk_profiles_id_seq'::regclass);


--
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- Name: asset_categories asset_categories_name_key; Type: CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.asset_categories
    ADD CONSTRAINT asset_categories_name_key UNIQUE (name);


--
-- Name: asset_categories asset_categories_pkey; Type: CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.asset_categories
    ADD CONSTRAINT asset_categories_pkey PRIMARY KEY (id);


--
-- Name: asset_classes asset_classes_pkey; Type: CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.asset_classes
    ADD CONSTRAINT asset_classes_pkey PRIMARY KEY (id);


--
-- Name: portfolio_asset_classes portfolio_asset_classes_pkey; Type: CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.portfolio_asset_classes
    ADD CONSTRAINT portfolio_asset_classes_pkey PRIMARY KEY (portfolio_id, asset_class_id);


--
-- Name: portfolios portfolios_pkey; Type: CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.portfolios
    ADD CONSTRAINT portfolios_pkey PRIMARY KEY (id);


--
-- Name: risk_profiles risk_profiles_pkey; Type: CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.risk_profiles
    ADD CONSTRAINT risk_profiles_pkey PRIMARY KEY (id);


--
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users users_username_key; Type: CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- Name: address address_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: asset_classes fk_asset_classes_category; Type: FK CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.asset_classes
    ADD CONSTRAINT fk_asset_classes_category FOREIGN KEY (category_id) REFERENCES public.asset_categories(id);


--
-- Name: portfolio_asset_classes portfolio_asset_classes_asset_class_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.portfolio_asset_classes
    ADD CONSTRAINT portfolio_asset_classes_asset_class_id_fkey FOREIGN KEY (asset_class_id) REFERENCES public.asset_classes(id);


--
-- Name: portfolio_asset_classes portfolio_asset_classes_portfolio_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.portfolio_asset_classes
    ADD CONSTRAINT portfolio_asset_classes_portfolio_id_fkey FOREIGN KEY (portfolio_id) REFERENCES public.portfolios(id);


--
-- Name: portfolios portfolios_risk_profile_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.portfolios
    ADD CONSTRAINT portfolios_risk_profile_id_fkey FOREIGN KEY (risk_profile_id) REFERENCES public.risk_profiles(id);


--
-- Name: portfolios portfolios_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: scorne
--

ALTER TABLE ONLY public.portfolios
    ADD CONSTRAINT portfolios_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- PostgreSQL database dump complete
--

