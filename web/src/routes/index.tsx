import React from "react";
import { HashRouter, Redirect, Route, Switch } from "react-router-dom";

import Login from "../pages/auth/Login";
import Cadastrar from "../pages/auth/Cadastrar";
import Recuperar from "../pages/auth/Recuperar";

import AdminRoutes from "./AdminRoutes";

import { isAuthenticated } from "../services/auth";

const PrivateRoute = ({ component, ...rest }: any) => {
  const routeComponent = (props: any) =>
    isAuthenticated() ? (
      React.createElement(component, props)
    ) : (
      <Redirect to={{ pathname: "/login" }} />
    );

  return <Route {...rest} render={routeComponent} />;
};

export default function Routes() {
  return (
    <HashRouter>
      <Switch>
        <Route exact path="/login" component={Login} />
        <Route exact path="/cadastrar" component={Cadastrar} />
        <Route exact path="/recuperar" component={Recuperar} />
        <PrivateRoute path="/" component={AdminRoutes} />
      </Switch>
    </HashRouter>
  );
}
