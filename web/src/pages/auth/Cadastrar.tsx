import React from "react";
import {
  Box,
  Button,
  ButtonGroup,
  Center,
  FormControl,
  Heading,
  Input,
  InputGroup,
  InputLeftElement,
  LightMode,
  Link,
  Stack,
  Switch,
  Text,
} from "@chakra-ui/react";
import { Icon } from "@chakra-ui/react";
import { FiLock, FiUser, FiUserPlus } from "react-icons/fi";
import { Link as ReactRouterDom } from "react-router-dom";

import Card from "../../components/Card";

const Cadastrar: React.FC = () => {
  return (
    <LightMode>
      <Center
        height="100vh"
        width="100%"
        position="relative"
        background="linear-gradient(-135deg, #1de9b6 0%, #1dc4e9 100%)"
      >
        <Box w="390px" p={4} zIndex="5" position="relative" boxShadow="md">
          <Card boxShadow="2xl">
            <Stack
              textAlign="center"
              py={8}
              px={[4, 6]}
              flex="1 1 auto"
              spacing={6}
            >
              <Box>
                <Icon
                  as={FiUserPlus}
                  fontSize={30}
                  color="#1de9b6"
                  _before={{
                    background:
                      "linear-gradient(-135deg, #1de9b6 0%, #1dc4e9 100%)",
                  }}
                />
              </Box>
              <Heading as="h3" fontWeight="400" color="black">
                Cadastrar
              </Heading>
              <FormControl mb={-2} id="first-name" isRequired>
                <InputGroup size="lg">
                  <InputLeftElement
                    p={0}
                    h="2.9rem"
                    top="0.1rem"
                    left="0.1rem"
                    borderLeftRadius="0.375rem"
                    bg="brand.100"
                    pointerEvents="none"
                    children={<FiUser />}
                  />
                  <Input type="text" placeholder="Nome" pl={16} bg="brand.50" />
                </InputGroup>
              </FormControl>
              <FormControl mb={-2} id="first-password" isRequired>
                <InputGroup size="lg">
                  <InputLeftElement
                    p={0}
                    h="2.9rem"
                    top="0.1rem"
                    left="0.1rem"
                    bg="brand.100"
                    borderLeftRadius="0.375rem"
                    pointerEvents="none"
                    children={<FiLock />}
                  />
                  <Input
                    type="password"
                    placeholder="Senha"
                    pl={16}
                    bg="brand.50"
                  />
                </InputGroup>
              </FormControl>
              <FormControl mb={-2} id="second-password" isRequired>
                <InputGroup size="lg">
                  <InputLeftElement
                    p={0}
                    h="2.9rem"
                    top="0.1rem"
                    left="0.1rem"
                    bg="brand.100"
                    borderLeftRadius="0.375rem"
                    pointerEvents="none"
                    children={<FiLock />}
                  />
                  <Input
                    type="password"
                    placeholder="Confirme a Senha"
                    pl={16}
                    bg="brand.50"
                  />
                </InputGroup>
              </FormControl>
              <Center alignItems="self-end" justifyContent="flex-start">
                <Switch mb={2} mr={2} defaultIsChecked />
                <Text fontSize="0.9rem" mb={-3}>
                  Deseja receber newsletter
                </Text>
              </Center>
              <ButtonGroup mb={2}>
                <Button
                  size="lg"
                  colorScheme="blue"
                  shadow="xl"
                  w={36}
                  mx="auto"
                >
                  Entrar
                </Button>
              </ButtonGroup>
              <Text fontSize="0.9rem">
                Já tem conta?
                <Link
                  as={ReactRouterDom}
                  to="/login"
                  fontWeight="bold"
                  color="gray.800"
                >
                  {" "}
                  Logar
                </Link>
              </Text>
            </Stack>
          </Card>
        </Box>
      </Center>
    </LightMode>
  );
};

export default Cadastrar;
