import axios from "axios";
import { useState } from "react";

const useSignup = () => {
  const [isSigningup, setIsSigningup] = useState(false);

  const signup = async ({ username, password, repeatPassword }) => {
    setIsSigningup(true);

    if (password !== repeatPassword) {
      console.log("different password");
      return;
    }

    try {
      const response = await axios.post(
        "https://travelplanner-333314.uc.r.appspot.com/signup",
        {
          username: username,
          password: password,
        }
      );

      if (response.status === 200) {
        return 200;
      }
    } catch (err) {
      console.log(err.message);
      return err.response.status;
    } finally {
      setIsSigningup(false);
    }
  };

  return { isSigningup, signup };
};

export default useSignup;
