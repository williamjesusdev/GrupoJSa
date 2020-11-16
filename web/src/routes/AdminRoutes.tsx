import React from "react";
import { Box, useDisclosure } from "@chakra-ui/react";
import { Redirect, Route, Switch } from "react-router-dom";

//import Header from "../components/Header";
import Sidebar from "../components/Sidebar";

import Dashboard from "../pages/admin/Dashboard";
//import Empresa from "../pages/admin/Empresas";
//import Imoveis from "../pages/admin/Imoveis";

export default function Routes() {
  const { isOpen, onToggle } = useDisclosure({ defaultIsOpen: true });
  const auxCollapse = isOpen ? "16.5rem" : "5rem";

  return (
    <React.Fragment>
      <Sidebar isOpen={isOpen} onToggle={onToggle} />
      <Box width={`calc(100vw - ${auxCollapse})`} ml={auxCollapse}>
        {/* <Header /> */}
        <Switch>
          <Route exact path="/" component={Dashboard} />
          {/* <Route path="/empresas" component={Empresa} />
          <Route path="/imobiliaria/imoveis" component={Imoveis} /> */}
          <Route component={() => <Redirect to="/" />} />
        </Switch>
      </Box>
    </React.Fragment>
  );
}
