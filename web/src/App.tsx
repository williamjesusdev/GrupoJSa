import * as React from "react";
import { ChakraProvider } from "@chakra-ui/react";

import theme from "./config/theme";

import Routes from "./routes";
import PageWrapper from "./components/PageWrapper";

const App = () => (
  <ChakraProvider theme={theme}>
    <PageWrapper>
      <Routes />
    </PageWrapper>
  </ChakraProvider>
);

export default App;
