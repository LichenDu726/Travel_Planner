import axios from "axios";
import { useState } from "react";

//import { TOKEN_KEY } from 'constants/constants';

export const useLogin = () => {
  const [isLoggingIn, setIsLoggingIn] = useState(false);

  const login = async ({ username, password }) => {
    setIsLoggingIn(true);
    const login_url =
      "https://travelplanner-333314.uc.r.appspot.com/login?username=" +
      username +
      "&password=" +
      password;
    try {
      console.log("loging");
      console.log(username);
      console.log(password);
      const response = await axios.post(login_url);
      console.log("done");

      if (response.status === 200) {
        //localStorage.setItem(TOKEN_KEY, response.data.token);
        return response.data.name;
      }
    } catch (err) {
      console.log(err.message);
    } finally {
      setIsLoggingIn(false);
    }
  };

  return { isLoggingIn, login };
};

export default useLogin;
