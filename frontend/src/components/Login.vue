<template>
      <form>
            <div class="form-group">
               <label for="exampleInputEmail1">Email address</label>
               <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
               
            </div>
            <div class="form-group">
               <label for="exampleInputPassword1">Password</label>
               <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <div class="form-check">
               
               <label class="form-check-label" for="exampleCheck1">Not Having an Account Yet? </label>
               <a href="/register"><b>Register</b></a>

            </div>
            <button type="submit" class="btn btn-primary">Login</button>
            <button type="submit" class="btn ">Cancel</button>
         </form>
</template>

<script>

export default {
  name: 'login',
  data() {
    return {
      user: new User('', ''),
      loading: false,
      message: ''
    }
  }
}
</script>

<style scoped>
label {
  display: block;
  margin-top: 10px;
}

</style>